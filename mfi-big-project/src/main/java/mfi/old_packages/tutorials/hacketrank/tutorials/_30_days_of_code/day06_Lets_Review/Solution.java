package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day06_Lets_Review;

import java.util.Scanner;

/*
Sample Input

2
Hacker
Rank
Sample Output

Hce akr
Rn ak 
 * */


public class Solution {
	public static void main(String[] args){
		// Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); 
		//sc.nextLine();
		String[] ar = new String[T];
		for(int i=0 ; i< T; i++){
			ar[i] = sc.next();
		}
		String evenStr = "", oddStr = "";
		for(int i=0; i< T; i++){
			String temp = ar[i];
			for(int j=0; j< temp.length();j++){
				if(j%2 == 0){
					evenStr += temp.charAt(j);
				}else{
					oddStr += temp.charAt(j);
				}
			}
			System.out.println(evenStr+" "+oddStr);
			evenStr = oddStr = "";
		}
		
		
		sc.close();
	}
}
