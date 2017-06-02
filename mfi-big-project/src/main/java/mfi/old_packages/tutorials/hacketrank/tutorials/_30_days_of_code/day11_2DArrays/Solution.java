package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day11_2DArrays;

import java.util.Scanner;

public class Solution {
	/*
    Sample Input

	1 1 1 0 0 0
	0 1 0 0 0 0
	1 1 1 0 0 0
	0 0 2 4 4 0
	0 0 0 2 0 0
	0 0 1 2 4 0
	Sample Output
	
	19
	Explanation
	
	 contains the following hourglasses:
	
	1 1 1   1 1 0   1 0 0   0 0 0
	  1       0       0       0
	1 1 1   1 1 0   1 0 0   0 0 0
	
	0 1 0   1 0 0   0 0 0   0 0 0
	  1       1       0       0
	0 0 2   0 2 4   2 4 4   4 4 0
	
	1 1 1   1 1 0   1 0 0   0 0 0
	  0       2       4       4
	0 0 0   0 0 2   0 2 0   2 0 0
	
	0 0 2   0 2 4   2 4 4   4 4 0
	  0       0       2       0
	0 0 1   0 1 2   1 2 4   2 4 0
	The hourglass with the maximum sum () is:
	
	2 4 4
	  2
	1 2 4
	  
	 * */
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		int arr[][] = new int[6][6];
//		for(int i=0;i<6;i++){
//			for(int j=0;j<6;j++){
//				arr[i][i] = sc.nextInt();
//			}
//		}
		
		int arr[][] = {   {1,1,1,0,0,0}
			             ,{0,1,0,0,0,0}
			             ,{1,1,1,0,0,0}
			             ,{0,0,2,4,4,0}
			             ,{0,0,0,2,0,0}
			             ,{0,0,1,2,4,0}
			           };
		int tot = -9*9;
		int temp = 0;
		for(int i=1;i<5;i++){
			for(int j=1;j<5;j++){
				temp = arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]+arr[i][j]+arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
				if(temp > tot){
					tot = temp;
				}
			}
		}
		System.out.println(tot);
		
		printArr(arr);
		sc.close();
	}
	private static void printArr(int[][] arr){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
