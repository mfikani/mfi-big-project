package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day14_Scope;

import java.util.Scanner;

public class ScopeSolution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]= sc.nextInt();
		}
		sc.close();
		
		Difference difference = new Difference(a);
		difference.computeDifference();
		System.out.println(difference.maximumDifference);
	}

}
