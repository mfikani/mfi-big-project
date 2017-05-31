package mfi.tech.java.other.makeConnection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MakeConnection {
	
	public static void main(String[] args) {
		MakeConnection obj = new MakeConnection();
		
		//COMMENT: return HttpURLConnection.HTTP_BAD_METHOD
//		obj.doMakeConnection("https://www.google.com");
		
		//COMMENT: return HttpURLConnection.HTTP_BAD_METHOD
//		obj.doMakeConnection("https://blondiebytes.github.io/");
		
		//COMMENT: working return JSON (application/json)
//		obj.doMakeConnection("http://ip.jsontest.com/");
		
		//COMMENT: working return html (text/html)
//		obj.doMakeConnection("http://www.siteprice.org/AnalyzeSite.aspx?url=www.jsontest.com");
		
		//COMMENT: working return html (text/html)
		obj.doMakeConnection("http://www.siteprice.org/website-worth/jsontest.com");
		
	}
	
	public void doMakeConnection(String url){
		System.out.println("*******************************\nSTART");
		System.out.println("Establishing Connection with Url :"+url);
		try {
			HttpURLConnection conn = null;
			if(url.startsWith("www")){
				url = "http://"+url;
			}else if (url.startsWith("http://")){
				conn = (HttpURLConnection)new URL(url).openConnection();
			}else{
				conn = (HttpsURLConnection)new URL(url).openConnection();
			}
			try{
				conn = (HttpsURLConnection) (new URL(url).openConnection());
			}catch(Exception e){
				if(e.getMessage().equals("sun.net.www.protocol.http.HttpURLConnection cannot be cast to javax.net.ssl.HttpsURLConnection")){
					conn = (HttpURLConnection) (new URL(url).openConnection());
				}
			}
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			System.out.println("RequestMethod :"+conn.getRequestMethod());

			DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
			String postDataBytes = "";
			wr.writeBytes(postDataBytes);
			wr.flush();
			wr.close();
//			System.out.println(">>> postDataBytes:"+postDataBytes);

			int responseCode = conn.getResponseCode();
			System.out.println("responseCode :"+responseCode);
			if(responseCode == HttpURLConnection.HTTP_OK) {
				// >>>> 
				String ss = convertStreamToString(conn.getInputStream());
				System.out.println("Connection InputStream:\n"+ss);


				String contentType = conn.getContentType();
				int contentLength = conn.getContentLength();
				System.out.println("contentType: "+contentType+"\tcontentLength: "+contentLength);
				String xlsContentType = contentType.split(";")[0];
				System.out.println("xlsContentType: "+xlsContentType);
				//            logger.info("xls content type : " + xlsContentType);
				//            if(xlsContentType.equals("application/vnd.ms-excel")) {
				//                File excelFile = createTempFile(inputStream,
				//						contentLength);
				//
				//                return excelFile;
				//            } else {
				//	            	  logger.info("The returned file is not with type Excel");
				//            }

			} 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("END\n************************************");
	}
	public String convertStreamToString(java.io.InputStream is) {
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		return s.hasNext() ? s.next() : "";
	}
}
