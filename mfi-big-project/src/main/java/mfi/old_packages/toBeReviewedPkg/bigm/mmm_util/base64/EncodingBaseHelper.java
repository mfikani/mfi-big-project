package mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.base64;

import org.apache.tomcat.util.codec.binary.Base64;

import mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.UtilHelper;
import sun.misc.BASE64Decoder;

public class EncodingBaseHelper extends UtilHelper{
	
	public static final String encoding = "UTF-8";
	
	public static void getClassHelperInfo(){
		System.out.println("**************************************************************************");
		System.out.println("MMM: This class [EncodingBaseHelper] use the Jars : commons-codec-1.3.jar ");
		System.out.println("**************************************************************************");
		System.out.println("\n");
	}
	
	/**
     * This method is used to decode bytes encoded by Base64 encoding.
     * 
     * @param base64Encoded
     * @return Decoded byte[]
     */
	public static byte[] decodeStringBase64(byte[] base64Encoded) throws Exception{
		byte[] result =  new byte[0];
		if(base64Encoded != null){
			Base64 base64 = new Base64();
			result = base64.decode(base64Encoded);
		}
		
		return result;
	}
	public static byte[] decodeStringBase64GOOD(byte[] base64Encoded) throws Exception{
		byte[] result =  new byte[0];
		if(base64Encoded != null){
			result = new BASE64Decoder().decodeBuffer(new String(base64Encoded,encoding));
		}
		return result;
	}
	
	/**
     * This method is used to encode bytes using Base64.
     * 
     * @param content
     * @return Encoded byte[]
     */
	public static byte[] getContentAsBase64(byte[] content) {
		Base64 base64 = new Base64();
		byte[] result = base64.encode(content);
		return result;
	}
	
	public static String getContentAsBase64AsString(byte[] encoded){
		return new String(encoded);
	}
	
	/**
     * HELP METHOD: to convert string to bytes
     * 
     * @param str
     * @return Decoded byte[]
     */
	public static byte[] getBites(String str) {
		return str.getBytes();
	}
	public static String getEncodingUTF8(){
		return encoding;
	}
}
