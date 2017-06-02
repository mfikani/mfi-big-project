package mfi.old_packages.toBeReviewedPkg.mfi.util.encodingBaseUtil;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
		

public class EncodingBase64Util {
	public static final String ENCODING = "UTF-8";
	
	/**
	 * This method is used to decode bytes encoded by Base64 encoding.
	 * 
	 * @param base64Encoded
	 * @return Decoded byte[]
	 */
	public static byte[] decodeStringBase64(byte[] base64Encoded){
		byte[] result = new byte[0];
		try{
			if(base64Encoded != null){
				result = new BASE64Decoder().decodeBuffer(new String(base64Encoded,ENCODING));
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		return result;
	}

	/**
	 * This method is used to encode bytes using Base64
	 * 
	 * @param content
	 * @return Encoded byte[]
	 */
	public static byte[] getContentAsBase64(byte[] content){
		return (new BASE64Encoder().encodeBuffer(content)).getBytes();
	}
	
	/**
	 * HELP METHOD: to convert string to bytes
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] getBytes(String str){
		return str.getBytes();
	}
	
	public static String getEncodingUTF8(){
		return ENCODING;
	}
}

