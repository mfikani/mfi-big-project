package mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.base64;

import java.io.UnsupportedEncodingException;

public class Base64Demo {

//	public static final String encoding = "UTF-8"; 
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		EncodingBaseHelper.getClassHelperInfo();
		String str1 = "hello 100 miled";
		String str2 = "hello � miled";
		
		// encoding - decoding will work for normal strings
		test1(str1);
		
		// encoding - decoding will GIVE ERRORS for special characters
		//test1(str2);
		
		// better using UTF-8 for encoding - decoding, work with special characters too
		//test2(str2);
		

	}
	
	public static String test1(String str) throws Exception {
		byte[] encodedByteArr = EncodingBaseHelper.getContentAsBase64(str.getBytes());
		byte[] decodedByteArr = EncodingBaseHelper.decodeStringBase64(str.getBytes());
		String encodedStr = new String(encodedByteArr);
		String decodedStr = new String (decodedByteArr);
		
		byte[] decodeEncodedStr = EncodingBaseHelper.decodeStringBase64(encodedByteArr);
		String decodeEncodedString = new String(decodeEncodedStr); 
		
		System.out.println("Original String >>> "+str);
		System.out.println("Encoded String >>> "+encodedByteArr+"\t"+encodedStr);
		System.out.println("Decoded String >>> "+decodedByteArr+"\t"+decodedStr);
		System.out.println("----------------------");
		System.out.println("Decoded of ["+encodedByteArr+"]: "+decodeEncodedString);
		return decodeEncodedString;
	}
	
	public static String test2(String str) throws UnsupportedEncodingException, Exception{
		byte[] encodedByteArr = EncodingBaseHelper.getContentAsBase64(str.getBytes(EncodingBaseHelper.encoding));
		byte[] decodedByteArr = EncodingBaseHelper.decodeStringBase64GOOD(str.getBytes(EncodingBaseHelper.encoding));
		String encodedStr = new String(encodedByteArr);
		String decodedStr = new String (decodedByteArr);
		
		byte[] decodeEncodedStr = EncodingBaseHelper.decodeStringBase64(encodedStr.getBytes(EncodingBaseHelper.encoding));
		String decodeEncodedString = new String(decodeEncodedStr,EncodingBaseHelper.encoding); 
		
		System.out.println("Original String >>> "+str);
		System.out.println("Encoded String >>> "+encodedByteArr+"\t"+encodedStr);
		System.out.println("Decoded String >>> "+decodedByteArr+"\t"+decodedStr);
		System.out.println("----------------------");
		System.out.println("Decoded of ["+encodedByteArr+"]: "+decodeEncodedString);
		return decodeEncodedString;
	}

}
