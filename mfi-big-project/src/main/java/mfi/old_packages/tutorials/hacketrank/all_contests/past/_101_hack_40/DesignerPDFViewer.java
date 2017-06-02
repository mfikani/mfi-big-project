package mfi.old_packages.tutorials.hacketrank.all_contests.past._101_hack_40;

import java.util.Scanner;

/*
 Sample Input

1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5
abc
Sample Output

9
Explanation

We are highlighting the word abc:

The tallest letter in abc is b, and h(b) = 3. The selection area for this word is 3.  1mm . 3 mm = 9 mm2; 
 * */

public class DesignerPDFViewer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 26;
		int h[] = new int[n];
		for(int h_i=0;h_i<n;h_i++){
			h[h_i]=sc.nextInt();
		}
		String word=sc.next();
		
		
		int l = 0;
		
		for(int i=0;i<word.length();i++){
			
			char c = word.charAt(i);
			
			if(h[getIndexOfChar(c)] > l){
				l = h[getIndexOfChar(c)];
			};
		}
		System.out.println(l*1*word.length());
		sc.close();

	}
	private static int getIndexOfChar(char c){
		String alphabets="abcdefghijklmnopqrstuvwxyz";
		int r = 0;
		for(int i=0;i<alphabets.length();i++){
			if(alphabets.charAt(i) == c){
				r = i;
				break;
			}
		}
		return r;
	}

}
