package mfi.tech.java.array.SparseArrays;

import java.util.Scanner;

public class SparseArraysSolution {
/*
url : https://www.hackerrank.com/challenges/sparse-arrays?h_r=next-challenge&h_v=zen

input : 
4
aba
baba
aba
xzxb
3
aba
xzxb
ab

output : 
2
1
0

Explanation : Here, "aba" occurs twice, in the first and third string. The string "xzxb" occurs once in the fourth string, 
and "ab" does not occur at all.
  
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		sc.nextLine();
		for(int i=0;i<n;i++){
			arr[i] = sc.nextLine();
		}
		
		int q = sc.nextInt();
		sc.nextLine();
		
		String[] arr_q = new String[q];
		for(int i=0;i<q;i++){
			arr_q[i] = sc.nextLine();
		}		
		sc.close();
		printArr(arr);
		printArr(arr_q);
		for(String s : arr_q){
			System.out.println(countOccurence(s,arr));
		}
	}
	public static int countOccurence(String s, String[] arr){
		int count = 0;
		for(String i : arr){
			if(s.equals(i)){
				count++;
			}
		}
		return count;
	}
	public static void printArr(String[] s){
		for(String i: s){
			System.out.println(i);
		}
		System.out.println();
	}
}
