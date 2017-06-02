package mfi.old_packages.tutorials.hacketrank.tutorials.cracking_the_code_interview.arrays_left_rotation;

import java.util.Scanner;

/*
 URL  : https://www.hackerrank.com/challenges/ctci-array-left-rotation 
 
 A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform). 
The second line contains  space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:
[2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]
Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4. 
  
 * */
public class ArraysLeftRotationsSolution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for(int a_i = 0;a_i<n;a_i++){
			a[a_i] = in.nextInt();
		}
		int[] output = new int[n];
		output = arrayLeftRotation(a,n,k);
		for(int i=0;i<n;i++){
			System.out.print(output[i]+" ");
		}
		System.out.println();
		in.close();
	}

	public static int[] arrayLeftRotation(int[] a, int n,int d){
		int[] temp = new int[n];
		//**********************************************
		// best solution
		// System.arraycopy(a, 0, temp, n - d,   d);
		// System.arraycopy(a, 0, temp, n - d,   d); 
		//**********************************************
		
		System.arraycopy(a, d, temp, 0    , n-d);
		System.out.println("111");
		for(int i : temp)
			System.out.print(i+" ");
		System.arraycopy(a, 0, temp, n - d,   d);
		System.out.println("\n222");
		for(int i : temp)
			System.out.print(i+" ");
		System.out.println("\n333");
		
		/*
		 or 
		 
		if(n != d){
			for(int i=0;i<n;i++){
				if(n == 1){
					temp[i] = a[i];
				}else if(i >= 0){
					//System.out.println(i+" : "+((n-d+i)%n));
					temp[(n-d+i)%n] = a[i];
				}
			}
		}else{
			temp = a;
		}
		*/
		return temp;
	}

}
