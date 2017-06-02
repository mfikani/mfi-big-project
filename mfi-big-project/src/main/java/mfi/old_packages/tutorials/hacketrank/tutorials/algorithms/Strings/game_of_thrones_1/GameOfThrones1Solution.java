package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.Strings.game_of_thrones_1;

import java.util.Scanner;

/*
 URL; https://www.hackerrank.com/challenges/game-of-thrones?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign 
 
 Game of Thrones - I 
by amititkgp
Problem
Submissions
Leaderboard
Discussions
Editorial 
Topics
Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

door

But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.

Input Format 
A single line which contains the input string.

Constraints 
 length of string  
Each character of the string is a lowercase English letter.

Output Format 
A single line which contains YES or NO in uppercase.

Sample Input : 01

aaabbbb
Sample Output : 01

YES
Explanation 
A palindrome permutation of the given string is bbaaabb. 

Sample Input : 02

cdefghmnopqrstuvw
Sample Output : 02

NO
Explanation 
You can verify that the given string has no palindrome permutation. 

Sample Input : 03

cdcdcdcdeeeef
Sample Output : 03

YES
Explanation 
A palindrome permutation of the given string is ddcceefeeccdd.
  
 * */
public class GameOfThrones1Solution {

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		String inputString = myScan.nextLine();
		
//		int[] freq = new int[26];
//        for(int i = 0; i < inputString.length(); i++)
//        {
//            freq[inputString.charAt(i) - 'a']++;
//        }
//        System.out.println(freq);
		
		String ans;
		char c;
		boolean middleNbrFound = false;
		boolean isAnagram = true;
		int count = 1;
		while(inputString.length() > 1){
			c = inputString.charAt(0);
			count = 1;
			for(int j=1;j<inputString.length();j++){
				if(c == inputString.charAt(j)){
					count++;
				}
				if(j == inputString.length()-1){
					if(count % 2 == 1){
						if(!middleNbrFound){
							middleNbrFound = true;
						}else{
							isAnagram = false;
							inputString = "";
							break;
						}
					}
					inputString = inputString.replaceAll(c+"", "");
				}
			}			
		}
		if(middleNbrFound && inputString.length() == 1){
			isAnagram = false;
		}
		
		ans = isAnagram?"YES":"NO";
		System.out.println(ans); 
		
		myScan.close();
	}

}
