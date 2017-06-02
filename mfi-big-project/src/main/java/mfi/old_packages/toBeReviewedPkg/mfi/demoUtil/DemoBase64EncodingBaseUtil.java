package mfi.old_packages.toBeReviewedPkg.mfi.demoUtil;

import mfi.old_packages.toBeReviewedPkg.mfi.util.encodingBaseUtil.EncodingBase64Util;

public class DemoBase64EncodingBaseUtil {

	public static void main(String[] args) {

		String str1 = "hello 100 miled";
		String str2 = "hello Ç £ miled مرحبا يا ميلاد";
		
		test1(str1+"\n"+str2);
	}
	
	public static String test1(String str){
		byte[] encodedByteArr = EncodingBase64Util.getContentAsBase64(str.getBytes());
		byte[] decodedByteArr = EncodingBase64Util.decodeStringBase64(str.getBytes());
		
		String encodedStr = new String(encodedByteArr);
		String decodedStr = new String(decodedByteArr);
		
		byte[] decodeEncodedStr = EncodingBase64Util.decodeStringBase64(encodedByteArr);
		String decodeEncodedString = new String(decodeEncodedStr);
		
		System.out.println("Original String >>>\n"+str);
		System.out.println("Encoded String >>> "+encodedByteArr+"\t"+encodedStr);
		System.out.println("Decoded String >>> "+decodedByteArr+"\t"+decodedStr);
		System.out.println("------------------");
		System.out.println("Decoded of ["+encodedByteArr+"]:\n"+decodeEncodedString);
		
		return decodeEncodedString;
	}

}
