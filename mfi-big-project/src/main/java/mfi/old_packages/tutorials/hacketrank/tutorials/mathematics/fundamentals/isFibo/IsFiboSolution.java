package mfi.old_packages.tutorials.hacketrank.tutorials.mathematics.fundamentals.isFibo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
/*
 url : https://www.hackerrank.com/challenges/is-fibo/copy-from/34236370
 
  You are given an integer, . Write a program to determine if  is an element of the Fibonacci sequence.

The first few elements of the Fibonacci sequence are 0,1,1,2,3,4,8,13, ... . A Fibonacci sequence is one where every element is a sum of the previous two elements in the sequence. The first two elements are  and .

Formally:
fib0 = 0;
fib1 = 1;
...
fibn = fibn-1 + fibn-2 Whatever n > 1 
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

Time Limit 
Time limit for this challenge is given here. 
 * */
public class IsFiboSolution {

	static HashSet<Long> fibs = new HashSet();
	
	public static void main(String[] args) {
		
		int scenario = 3;
		if(scenario == 0){
			doTest();
		}else if(scenario == 1){
			doScenario1();
		}else if(scenario == 2){
			doScenario2();
		}else if(scenario == 3){
			doScenario3();
		}else if(scenario == 4){
			doScenario4();
		}
	}
	private static void doScenario4(){
		// ln = ln-1 + ln-2;
		long A = System.currentTimeMillis();
		long l1 = 0;
		long l2 = 1;
		long l3 = 0;
		long max = 10000000000L;
		ArrayList lt = new ArrayList();
		lt.add(l1);
		lt.add(l2);
		while(l3 < max){
			l3 = l1+l2;
			l1 = l2;
			l2 = l3;
			lt.add(l3);
		}
		long B = System.currentTimeMillis();
		System.out.println(B-A);
		System.out.println(lt.size());		
		for(int i =0;i<lt.size();i++){
			System.out.println(lt.get(i));
		}
	}
	
	private static void doScenario3(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long l1 = 0;
		long l2 = 1;
		long l3 = 0;
		long max = 10000000000L;
		ArrayList lt = new ArrayList();
		lt.add(l1);
		lt.add(l2);
		while(l3 < max){
			l3 = l1+l2;
			l1 = l2;
			l2 = l3;
			lt.add(l3);
		}
		
		long x = 0;
		for(int i=0;i<n;i++){
			x = sc.nextLong();
			//System.out.println(i+" : "+x);
			if(lt.contains(x)){
				System.out.println("IsFibo");
			}else{
				System.out.println("IsNotFibo");				
			}
		}
		sc.close();
	}
	
	private static void doTest(){
		long A = System.currentTimeMillis();
//		long max = 10000000000l;
//        long a = 1, b = 1, c;
//        fibs.add(0l);
//        fibs.add(1l);
//        do{
//            c = a+b;
//            fibs.add(c);
//            a = b;
//            b = c;
//        }while(c <= max);
        
        long max2 = 10000000000L;
		List fibList = new ArrayList();
		long l = 0;
		int i = 0;
		do{
			l = isFibo(i);
			//System.out.println(i+" :"+l + " : "+ max + " ==>"+(max - l)+"  : "+(l < max));
			i++;
			fibList.add(l);
		}while(l < max2);
        
        System.out.println(fibs);
        System.out.println(fibs.size());
        System.out.println(System.currentTimeMillis() - A);
        
		
	}
	private static void doScenario2(){
		  long max = 10000000000l;
	        long a = 1, b = 1, c;
	        fibs.add(0l);
	        fibs.add(1l);
	        do{
	            c = a+b;
	            fibs.add(c);
	            a = b;
	            b = c;
	        }while(c <= max);
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int i = 0; i < t; i++) System.out.println(isFib(in.nextLong()));
	}
	private static String isFib(long n){
        return fibs.contains(n)? "IsFibo":"IsNotFibo";
    }
	
	
	private static void doScenario1(){
		Scanner sc = new Scanner(System.in) ;
		int t = sc.nextInt();
		long[] n  = new long[t];
		long max = 10000000000l;
		List fiboList = new ArrayList();
		
		for(int i=0;i<=max;i++){
			long l = isFibo(i);
			System.out.println(i+ " : "+l);
			if(l > max)break;
//			if(!fiboList.contains(l)){
				fiboList.add(l);
//			}
		}
		System.out.println(fiboList.size());
		for(int i=0;i<t;i++){
			if(fiboList.contains(sc.nextLong())){
				System.out.println("IsFibo");
			}else{
				System.out.println("IsNotFibo");
			}
		}
		
		sc.close();
	}
	
	private static long isFibo(long n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else{
			long res = (isFibo(n-1)+isFibo(n-2));
			return res;

		}
	}
}
