package mfi.old_packages.tutorials.hacketrank.tutorials.cracking_the_code_interview.strings_making_anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 URL: https://www.hackerrank.com/challenges/ctci-making-anagrams
 
  Check out the resources on the page's right side to learn more about strings. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

This challenge is also available in the following translations:

Chinese
Russian
Input Format

The first line contains a single string, . 
The second line contains a single string, .

Constraints

It is guaranteed that  and  consist of lowercase English alphabetic letters (i.e.,  through ).
Output Format

Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

Sample Input

cde
abc
Sample Output

4
Explanation

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.

Input
fcrxzwscanmligyxyvym
jxwtrhvujlmrpdoqbisbwhmgpmeoke

Output
30
  
 * */
public class Strings_Making_Anagrams {

	public static int numberNeeded(String first, String second) {
	   int res = 0;
	   char[] firstArr = first.toCharArray();
	   char[] secondArr = second.toCharArray();
	   Arrays.sort(firstArr);
	   Arrays.sort(secondArr);
	   System.out.println(firstArr);
	   System.out.println(secondArr);
	   int i = 0;
	   int[] firstAr = new int[26];
	   int[] secondAr = new int[26];
	   for(i=0;i<firstArr.length;i++){
		   firstAr[firstArr[i]-'a']++;
	   }
	   for(i=0;i<secondArr.length;i++){
		   secondAr[secondArr[i]-'a']++;
	   }
	   int x = 0;
	   for(i=0;i<26;i++){
		   x += Math.abs(firstAr[i] - secondAr[i]);
	   }
	   
	   return x;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

}
