package mfi.tech.java.recursive.palindrom;

public class IsPalindromRecusive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 aba => isPalindrom 	= true
		 ab => isPalindrom 	= false 
		 * 
		 * */
		IsPalindromRecusive obj = new IsPalindromRecusive();
		
		obj.doTestIsPalindrom(null);
		obj.doTestIsPalindrom("a");
		obj.doTestIsPalindrom("aa");
		obj.doTestIsPalindrom("aaa");
		obj.doTestIsPalindrom("aaaa");
		obj.doTestIsPalindrom("  a ");
		System.out.println();
		obj.doTestIsPalindrom("  a a");
		obj.doTestIsPalindrom("abcdcba");
		obj.doTestIsPalindrom("abccba");
		obj.doTestIsPalindrom(" good  good ");
		
		System.out.println();
		obj.doTestIsPalindrom(" kayak    kayak ");
		System.out.println();
		obj.doTestIsPalindrom(" a man a plan a canal panama ");
	}

	public void doTestIsPalindrom(String x){
		System.out.println("["+x+"] \t\t isPalindrom :\t\t"+isPalindrom(x));
	}
	
	public boolean isPalindrom(String s){
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
