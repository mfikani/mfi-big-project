package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.sorting.insertionSort_part1;

import java.util.Scanner;

/*
Sample Input

5
2 4 6 8 3

Sample Output

2 4 6 8 8 
2 4 6 6 8 
2 4 4 6 8 
2 3 4 6 8  
 * */
public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		int s = sc.nextInt();
//		int[] ar = new int[s];
//		for(int i=0;i<s;i++){
//			ar[i]=sc.nextInt();
//		}
		
//		int[] ar = {2,4,6,8,9};
//		int[] ar = {1 ,3 ,5 ,9 ,13 ,22 ,27 ,35 ,46 ,51 ,55 ,83 ,87 ,23};
//		int[] ar = {2,1};
//		int[] ar = {2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,1};
		int[] ar = {2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 ,1};
		
		insertIntoSorted(ar);
		
		sc.close();
	}
	private static void insertIntoSorted(int[] ar){
		int len = ar.length;
		int v = ar[ar.length-1];
		//COMMENT: if array size equal 1 : do nothing
		if(len == 1){
			printArray(ar);
		}else{
			//COMMENT: if v greater or equal to the right element ( ar[len-1] ) : do nothing
			for(int i = len-2;v < ar[len -2] && i >= 0;i-- ){
				//COMMENT: if v less than element ar[i],  put element right ar[i+1] = ar[i]
				if(v <= ar[i]){
					ar[i+1] = ar[i];
					
					//COMMENT: if there are no more element to compare, put first element = v 
					if(i == 0){
						printArray(ar);
						ar[i] = v;
					}
					printArray(ar);
				}else{
					//COMMENT: if v greater than element ar[i], put v on right of element ar[i]
					ar[i+1] = v;
					printArray(ar);
					break;
				}
			}
		}			
	}
	private static void printArray(int[] ar){
		for(int n : ar){
			System.out.print(n+" ");
		}
		System.out.println("");
	}
}
