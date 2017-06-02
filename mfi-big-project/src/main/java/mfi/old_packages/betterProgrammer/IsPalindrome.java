package mfi.old_packages.betterProgrammer;

public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ss(isPalindrome(null)+"");

	}
	public static boolean isPalindrome(String s) {
        /*
          Definition: A palindrome is a string that reads the same forward and backward.
          For example, "abcba" is a palindrome, "abab" is not.
          Please implement this method to
          return true if the parameter is a palindrome and false otherwise.
         */
		boolean res = false;
		if(s!= null && s.length() > 0){
			res = true;
			for(int i=0;i<s.length();i++){
				if(s.charAt(i) != s.charAt(s.length()-i-1)){
					res = false;
					break;
				}
			}
		}
		return res;
    }
	private static void ss(String x){
		System.out.println("--- :"+x+":");
	}
}
