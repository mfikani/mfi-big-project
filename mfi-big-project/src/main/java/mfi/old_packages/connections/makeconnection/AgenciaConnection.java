//package mfi.old_packages.connections.makeconnection;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.UnsupportedEncodingException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.security.KeyManagementException;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.security.SecureRandom;
//import java.security.UnrecoverableKeyException;
//import java.security.cert.CertificateException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import javax.net.ssl.HttpsURLConnection;
//import javax.net.ssl.KeyManager;
//import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocketFactory;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.TrustManagerFactory;
//
//import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//
///**
// * mantis 4896
// *
// */
//public class AgenciaConnection {
//
//	private final static Logger logger = Logger.getLogger(AgenciaConnection.class.getSimpleName());
//	
//
//	private Map<String, Object> parameters;
//	
//    private AgenciaConfiguration getConfiguration() {
//    	return AgenciaConfiguration.get();
//    }
//    
//    public AgenciaConnection(Map<String, Object> parameters) {
//    	this.parameters = parameters;
//    	if(parameters ==null) {
//    		throw new IllegalArgumentException(parameters+"must not be null");
//    	}
//    }
//
//    public List<AgenciaDeclaration> execute() throws Exception {
//    	//download file from url
//		File downloadAccountFile = downloadAccountFile();
//		
//		//get values
//		List<AgenciaDeclaration> outputs= extractMrnDateMap(downloadAccountFile);
//		
//		//delete temp file
//		FileUtils.forceDelete(downloadAccountFile);
//		
//		return outputs;
//    }
//
//
//    /**
//     * download file from url to use later for updating declaration status
//     * @return
//     * @throws Exception
//     */
//    private  File downloadAccountFile() throws Exception {
//
//    	 HttpsURLConnection connection = null;
//    	 InputStream inputStream = null;
//    	try {
//    		
//		//create connection
//        connection = createHttpsConnection();
//        
//        //connect and get response
//        int responseCode = connection.getResponseCode();
//        logger.info("Response Code :"+responseCode);
//        
//        if(responseCode == HttpURLConnection.HTTP_OK) {
//            inputStream = connection.getInputStream();
//
//            String contentType = connection.getContentType();
//            int contentLength = connection.getContentLength();
//
//            String xlsContentType = contentType.split(";")[0];
//
//            logger.info("xls content type : " + xlsContentType);
//
//            if(xlsContentType.equals("application/vnd.ms-excel")) {
//                File excelFile = createTempFile(inputStream,
//						contentLength);
//
//                return excelFile;
//            } else {
//	            	  logger.info("The returned file is not with type Excel");
//            }
//            
//        }
//        
//        throw new Exception("Connection Error");
//    	} finally {
//			if(inputStream!=null) {
//				inputStream.close();
//			}
//		}
//    }
//
//	private  File createTempFile(InputStream inputStream,int contentLength){
//		
//		DataInputStream din = null;
//		File excelFile = null;
//		FileOutputStream fileOutputStream  = null;
//		try {
//			String fileName = "tmp.xls";
//			din = new DataInputStream(inputStream);
//			byte[] buffer = new byte[contentLength];
//			try {
//				din.readFully(buffer);
//				din.close();
//				excelFile = new File(fileName);
//				fileOutputStream = new FileOutputStream(excelFile);
//				fileOutputStream.write(buffer);
//				fileOutputStream.close();
//			} catch (IOException e) {
//				logger.error(e.getMessage());
//			}
//		return excelFile;
//		}
//		finally {
//			
//				try {
//					if (din != null) {
//						din.close();
//					}
//	
//					if (fileOutputStream != null) {
//						fileOutputStream.close();
//					}
//				} catch (IOException e) {
//					logger.error(e.getMessage());
//				}
//			
//		}
//	}
//
//	private  HttpsURLConnection createHttpsConnection() throws IOException, MalformedURLException,
//			FileNotFoundException, KeyStoreException, NoSuchAlgorithmException,
//			CertificateException, UnrecoverableKeyException,
//			NoSuchProviderException, KeyManagementException, ProtocolException {
//		
//		logger.info("getting parameters");
//        String postDataBytes = getParameters();
//        logger.info("End getting parameters "+postDataBytes);
//        
//		//Create Https Connection
//        String url = getConfiguration().getUrl();
//        
//        logger.info("Establishing Connection with Url :"+url);
//        HttpsURLConnection conn = (HttpsURLConnection) (new URL(url).openConnection());
//        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//        conn.setSSLSocketFactory(getSSLSocketFactoryFromCertificate());
//        conn.setRequestMethod("POST");
//        conn.setUseCaches(false);
//        conn.setDoOutput(true);
//        conn.setDoInput(true);
//        logger.info("End Establishing Connection "+conn.getRequestMethod());
//        
//        //Post Values
//        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
//		wr.writeBytes(postDataBytes);
//		wr.flush();
//		wr.close();
//		return conn;
//	}
//
//	private  String getParameters()
//			throws UnsupportedEncodingException {
//
//        StringBuilder postData = new StringBuilder();
//        for (Map.Entry<String, Object> param : parameters.entrySet()) {
//            if (postData.length() != 0) {
//            	postData.append('&');
//            }
//            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
//            postData.append('=');
//            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
//        }
//        return postData.toString();
//	}
//
//	/**
//	 * get SSlFactory from certificate
//	 * @param certificate certificate path
//	 * @param certificatePassword certificate password
//	 * @param cacerts cacerts Path
//	 * @param cacertsPassword cacerts password
//	 * @return
//	 * @throws KeyStoreException
//	 * @throws NoSuchAlgorithmException
//	 * @throws CertificateException
//	 * @throws FileNotFoundException
//	 * @throws IOException
//	 * @throws UnrecoverableKeyException
//	 * @throws KeyManagementException
//	 */
//	private SSLSocketFactory getSSLSocketFactoryFromCertificate() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException, UnrecoverableKeyException, KeyManagementException {
//			
//		String certificate = getConfiguration().getCertificate();
//		String certificatePassword = getConfiguration().getCertificatePassword(); 
//		String cacerts = getConfiguration().getCacerts(); 
//		String cacertsPassword = getConfiguration().getCacertsPassword();
//		
//		KeyStore clientStore = KeyStore.getInstance("PKCS12");
//        clientStore.load(new FileInputStream(certificate), certificatePassword.toCharArray());
//
//        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//        kmf.init(clientStore, certificatePassword.toCharArray());
//        KeyManager[] kms = kmf.getKeyManagers();
//
//        KeyStore trustStore = KeyStore.getInstance("JKS");
//        trustStore.load(new FileInputStream(cacerts), cacertsPassword.toCharArray());
//
//        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//        tmf.init(trustStore);
//        TrustManager[] tms = tmf.getTrustManagers();
//
//        SSLContext sslContext = null;
//        sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(kms, tms, new SecureRandom());
//
//        return sslContext.getSocketFactory();
//	}
//	
//    private  List<AgenciaDeclaration> extractMrnDateMap(File xlsFile) throws IOException {
//
//    	List<AgenciaDeclaration> outputs = new ArrayList<>();
//        FileInputStream fis = new FileInputStream(xlsFile);
//        HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(fis));
//
//        Sheet firstSheet = workbook.getSheetAt(0);
//        Iterator<Row> iterator = firstSheet.iterator();
//
//        iterator.next();
//        while (iterator.hasNext()) {
//
//            Row nextRow = iterator.next();
//
//            String mrn = nextRow.getCell(0).getStringCellValue();
//            String date = nextRow.getCell(12).getStringCellValue();
//
//            AgenciaDeclaration output = new AgenciaDeclaration();
//            output.setMrn(mrn);
//            output.setReceptionDate(date);
//            
//            outputs.add(output);
//        }
//
//        fis.close();
//        return outputs;
//    }
//
//
//}
