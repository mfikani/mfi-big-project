package mfi.tech.java.array.LeftRotation;

import java.util.Scanner;

public class LeftRotationSolution {
/*
 url : https://www.hackerrank.com/challenges/array-left-rotation 
 
 Input : 
 5 4
 1 2 3 4 5

 ouput : 
 5 1 2 3 4
 
 When we perform d = 4 left rotations, the array undergoes the following sequence of changes:
 1 2 3 4 5 -> 2 3 4 5 1 -> 3 4 5 1 2 -> 4 5 1 2 3 -> 5 1 2 3 4  
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] arr = new int[n];
		int[] arr1 = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}		
		sc.close();
		
		printArr(arr);
		
		for(int i=0;i<n;i++){
			arr1[i] = arr[(i+d)%n]; 
		}		
		
		printArr(arr1);
	}
	public static void printArr(int[] ar){
		for(int i : ar){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
