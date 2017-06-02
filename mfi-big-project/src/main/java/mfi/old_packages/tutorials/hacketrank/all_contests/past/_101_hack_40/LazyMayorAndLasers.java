package mfi.old_packages.tutorials.hacketrank.all_contests.past._101_hack_40;

import java.util.Scanner;

import mfi.old_packages.toBeReviewedPkg.mfi.util.ioUtil.InputOutputUtil;

public class LazyMayorAndLasers {

/*
 * url : https://www.hackerrank.com/contests/101hack40/challenges/lazy-mayor-and-lasers
 * 
 * 
Sample Input

5
3 1 4 5 1
2
3 5
Sample Output

7
 
 * */	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		int[] h = readArray(n,in);
//		int[] h = new int[n];
//		for(int i=0;i<n;i++){
//			h[i]=in.nextInt();
//		}
		in.nextLine();
		int m = in.nextInt();
//		in.nextLine();
//		int[] x = new int[m];
//		for(int i=0;i<m;i++){
//			x[m]=in.nextInt();
//		}
		int[] x = InputOutputUtil.readArray(m,in);
		int currentIndex = 0;
		int sum = 0;
		
		for(int i=0;i<m;i++){
			for(int j=1;j<n+1;j++){
				System.out.println("x[i] ="+x[i] +" | j = "+j+"   and currentIndex:"+currentIndex);
				if(x[i] > j && j >= currentIndex){
					System.out.println(x[i]+" - "+j+" : "+(x[i]-j));
					sum += (x[i]-j);
				}else{
					currentIndex = x[i];
					continue;
				}
			}
		}
		
//		for(int i=1;i<n+1;i++){
//			for(int j=0;j<m;j++){
//				if(i<x[j] && x[j] > currentIndex){
//					sum += (x[j]-i);
//				}else{
//					currentIndex = j;
//				}
//			}
//		}
		System.out.println(sum);
		printArray(h);
		printArray(x);
		
		in.close();
	}
	private static int[] readArray(int l, Scanner in){
		//in.nextLine();
		int[] res = new int[l];
		for(int i=0;i<l;i++){
			res[i] = in.nextInt();
		}
		return res;
	}
	private static void printArray(int[] ar){
		for(int x : ar){
			System.out.print(x+" ");
		}
		System.out.println();
	}

}
