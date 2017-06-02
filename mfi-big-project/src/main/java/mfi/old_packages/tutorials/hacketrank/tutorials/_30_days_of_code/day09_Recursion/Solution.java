package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day09_Recursion;

import java.util.Scanner;

/*
 Sample Input

3
Sample Output

6 

factorial(n) =
- 1 					if n <= 1 
- n x factorial(n-1)	otherwise

 * */

public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n));
		sc.close();
	}

	private static int factorial(int n){
		System.out.println("n:"+n);
		if(n <= 1){
			return 1;
		}else{
			return ( n * factorial(n-1));
		}
	}
}
