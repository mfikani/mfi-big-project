package mfi.old_packages.betterProgrammer;

public class CountWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countWords("hello   miled i am  fine  "));
	}
	public static int countWords(String s) {
        /*
          Please implement this method to return the word count in a given String.

          The words in the parameter String can be separated from each other by any nubmer
          of whitespace symbols (Character.isWhitespace()).
         */
		String[] ar = s.split(" ");
		int count = 0;
		for(String ss : ar){
			System.out.println(ss);
			System.out.println(":"+ss.trim()+":");
			if(ss.trim().length() != 0)
				count++;
		}
		return count;
    }
}
