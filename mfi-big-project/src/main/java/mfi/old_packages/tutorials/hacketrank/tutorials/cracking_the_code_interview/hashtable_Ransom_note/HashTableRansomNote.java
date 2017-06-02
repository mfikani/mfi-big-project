package mfi.old_packages.tutorials.hacketrank.tutorials.cracking_the_code_interview.hashtable_Ransom_note;

import java.util.Map;
import java.util.Scanner;
/*
 url: https://www.hackerrank.com/challenges/ctci-ransom-note 
  
 Sample Input

6 4
give me one grand today night
give one grand today
Sample Output

Yes
Explanation

All four words needed to write an untraceable replica of the ransom note are present in the magazine, so we print Yes as our answer.
 
 * */
public class HashTableRansomNote {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;
	HashTableRansomNote(String magazine, String note){
		
	}
	public boolean solve(){
		return false;
		
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		//
		sc.nextLine();
		
		HashTableRansomNote s = new HashTableRansomNote(sc.nextLine(), sc.nextLine());
		sc.close();
		
		
		boolean answer = s.solve();
		if(answer){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}		
	}

}
