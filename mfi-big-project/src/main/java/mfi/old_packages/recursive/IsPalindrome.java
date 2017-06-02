package mfi.old_packages.recursive;

public class IsPalindrome {

	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * "aba"  : (a == a) && (b == b)
		 * "abba" : (a == a) && (b == b) 
		 */
//		System.out.println(" :" + isPalindrom("aa   abba a") + ": ");
		String test = "a man a plan a canal panama";
			   test = "a";
			   test = null;
			   test = "  a a";
		System.out.println("\""+test+"\" is Palindrom : " + isPalindrom(test) + " : ");
	}
	public static boolean isPalindrom(String s){
		// to ignore spaces
		if(s!=null){
			s = s.replaceAll(" ", "");
		}
		if(s == null){
			return false;
		}else if(s.length() == 1){
			return true;
		}else if(s.length() == 2 && s.charAt(0) == s.charAt(1)){
			return true;
		}else if(s.charAt(0) == s.charAt(s.length()-1)){
			return isPalindrom(s.substring(1,s.length()-1));
		}else{
			return false;
		}
	}

}
