package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.Strings.two_strings;

import java.util.Scanner;

/*
 URL : https://www.hackerrank.com/challenges/two-strings?h_r=next-challenge&h_v=zen
 
  Two Strings 
  
  Given two strings,  and , determine if they share a common substring.

Input Format

The first line contains a single integer, , denoting the number of  pairs you must check. 
Each pair is defined over two lines:

The first line contains string .
The second line contains string .
Constraints

 and  consist of lowercase English letters only.
Output Format

For each  pair of strings, print YES on a new line if the two strings share a common substring; if no such common substring exists, print NO on a new line.

Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

We have  pairs to check:

, . The substrings  and  are common to both  and , so we print YES on a new line.
, . Because  and  have no common substrings, we print NO on a new line.
 * */
public class TwoStringsSolutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		String s1 = "";
		String s2 = "";
		sc.nextLine();
		int[] freq = new int[26];
		int[] freq2= new int[26];
		boolean hasSubStringInCommon = false;
		for(int i=0;i<p;i++){
			s1 = sc.nextLine();
			s2 = sc.nextLine();
			freq = new int[26];
			freq2= new int[26];
			hasSubStringInCommon = false;
			for(int j=0;j<s1.length();j++){
				freq[s1.charAt(j) - 'a']++;
			}
			for(int j=0;j<s2.length();j++){
				freq2[s2.charAt(j) - 'a']++;
			}
			for(int j=0;j<26;j++){
				if(freq[j] > 0 && freq2[j] > 0){
//					System.out.println("\n"+freq[j] + " "+freq2[j]+" : "+((char)(j+'a')));
					//System.out.println((char)(j+'a') + " " + ((char)j+'a'));
					
					hasSubStringInCommon = true;
					break;
				}
			}
			System.out.println(hasSubStringInCommon?"YES":"NO");
		}
		sc.close();
	}

}
