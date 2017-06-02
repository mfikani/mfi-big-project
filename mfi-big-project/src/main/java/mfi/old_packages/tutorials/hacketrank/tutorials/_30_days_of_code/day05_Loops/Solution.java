package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day05_Loops;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		for(int i=1; i<=10; i++){
			System.out.println(N+" x "+i+" = "+(N*i));
		}
		
		in.close();
	}
}
