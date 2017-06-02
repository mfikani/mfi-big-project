package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day10_BinaryNumbers;

import java.util.Scanner;

/*
 5 = 0 x pow(2,0) + 0 x pow(2,1) + 0 x pow(2,2)  
 * */
public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		//int n = 34;
		int n = 7;
		// testinggggg
//		System.out.println(n%2);
//		System.out.println(n/2);
		int r = 0; 
		String s = "";
		while(n>=2){
			r = n%2;
			s +=r;
			n = n/2;
			if(n < 2){
				s +=n;
			}
			System.out.println(n+":"+r);
		}
		System.out.println(s);
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(i < s.length()-1 && s.charAt(i) == '1' && s.charAt(i+1) == '1'){
				count++;
			}
		}
		System.out.println("count: "+count);
		
		sc.close();
	}

}
