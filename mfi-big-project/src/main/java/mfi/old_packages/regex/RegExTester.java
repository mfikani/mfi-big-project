package mfi.old_packages.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "h1..";
		//String format="^\\d{2}[- ]\\d{3}";
		System.out.println("Matching:\n");
		
		String format = "[a-zA-Z]{2}.{1,33}";
		//[a-zA-Z]{2}.{1,33}  => 2 digits then alfanumb cardinality between 1 and 33 times
		
		doTestRegEx(str,format);
		doTestRegEx("AB123",format);
		
		
	}
	
	private static void doTestRegEx(String str, String format){
		Pattern patternPostCode = Pattern.compile(format);
		Matcher matcher = patternPostCode.matcher(str);
		boolean isMatched = matcher.matches();
		System.out.println("String : ["+str+"]\nFormat : "+format+"\nResult :  " + isMatched+"\n");
	}

}
