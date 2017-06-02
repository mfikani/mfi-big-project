package mfi.old_packages.tutorials.hacketrank.tutorials.mathematics.fundamentals.is_fibo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 https://www.hackerrank.com/challenges/is-fibo?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaignhttps://www.hackerrank.com/challenges/is-fibo?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 
 Is Fibo 
by shashank21j
Problem
Submissions
Leaderboard
Discussions
Editorial 
Topics
You are given an integer, . Write a program to determine if  is an element of the Fibonacci sequence.

The first few elements of the Fibonacci sequence are 0,1,1,2,3,5,8,13,... . A Fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are  and .
Formally: 

fib0 = 0
fib1  = 1
...
fibn = fibn-1 + fibn-2 whatever n > 1
Input Format 
The first line contains , number of test cases. 
 lines follow. Each line contains an integer .

Output Format 
Display IsFibo if  is a Fibonacci number and IsNotFibo if it is not. The output for each test case should be displayed in a new line.

Constraints 
 

Sample Input

3
5
7
8
Sample Output

IsFibo
IsNotFibo
IsFibo
Explanation 
 is a Fibonacci number given by  
 is not a Fibonacci number 
 is a Fibonacci number given by  
 
 * */
public class IsFiboSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		int t = sc.nextInt();
		long[] n  = new long[t];
		long max = 0;
		for(int i=0;i<t;i++){
			n[i] = sc.nextLong();
			if(max < n[i]){
				max = n[i];
			}
//			System.out.println("Testing : "+n[i]+" "+testIfFibo(n[i]));
//			System.out.println(testIfFibo(n[i]));
		}
		List fibNbr = new ArrayList();
		for(int i=0;i<max;i++){
			fibNbr.add(isFibo(i));
		}
		for(int i=0;i<t;i++){
			if(fibNbr.contains(n[i])){
				System.out.println("isFibo");
			}else{
				System.out.println("isNotFibo");
			}
		}
		sc.close();
	}
	private static String testIfFibo(long n){
		String res = "";
		for(int j=0;j<=n+1;j++){
			//System.out.println("isFibo("+j+") = "+isFibo(j));				
			if(isFibo(j) == n){
				res = ("IsFibo");
				break;
			}else if(isFibo(j) > n){
				res = ("IsNotFibo");
				break;
			}else{
				continue;
			}
		}
		return res;
	}
	private static long isFibo(long n){
		if(n == 0){
//			System.out.println("isFibo("+n+") = 0");
			return 0;
		}else if(n == 1){
//			System.out.println("isFibo("+n+") = 1");
			return 1;
		}else{
			long res = (isFibo(n-1)+isFibo(n-2));
//			System.out.println("isFibo("+n+") = "+res);
			return res;
			
		}
	}
}
