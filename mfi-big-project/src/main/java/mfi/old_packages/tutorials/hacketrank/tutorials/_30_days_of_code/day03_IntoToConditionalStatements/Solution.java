package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day03_IntoToConditionalStatements;

import java.util.Scanner;

/*
 Sample Input 0

3
Sample Output 0

Weird
Sample Input 1

24
Sample Output 1

Not Weird
Explanation

Sample Case 0:  
 is odd and odd numbers are weird, so we print Weird.

Sample Case 1:  
 and  is even, so it isn't weird. Thus, we print Not Weird.
 */
public class Solution {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();		
		String ans = "";
		
		// if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
		if(n%2==1){
			ans = "Weird";
		}else{
			// Complete the code
			if(2 <= n && n <= 5){
				ans = "Not Weird";
			}else if(6 <= n && n <= 20){
				ans = "Weird";
			}else{
				ans = "Not Weird";
			}
		}
		System.out.println(ans);
		
		
	}

}
