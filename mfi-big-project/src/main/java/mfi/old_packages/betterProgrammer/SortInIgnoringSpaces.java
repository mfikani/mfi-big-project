package mfi.old_packages.betterProgrammer;

import java.util.Arrays;
import java.util.Comparator;

public class SortInIgnoringSpaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"miled", " fikani", "   a", "b"};
		sortIgnoringSpaces(a);
	}
	public static void sortIgnoringSpaces(String[] a) {
        /*
          Please implement this method to
          sort a given array of Strngs in alphabetical order
          ignoring spaces (' ' symbols) within the strings.
         */
		for(String ss : a){
			System.out.println(ss);
		}
		if(a!=null && a.length>0){
			Arrays.sort(a, new Comparator<String>(){
				public int compare(String s1, String s2){
					return (s1.trim()).compareTo(s2.trim());
				}
			});
		}
		for(String ss : a){
			System.out.println(ss);
		}
    }

}
