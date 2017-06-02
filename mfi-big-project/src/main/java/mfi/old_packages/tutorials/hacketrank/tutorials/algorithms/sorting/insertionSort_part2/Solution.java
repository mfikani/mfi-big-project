package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.sorting.insertionSort_part2;

import java.util.Scanner;

/*
Sample Input

6
1 4 3 5 6 2
Sample Output

1 4 3 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 3 4 5 6 2 
1 2 3 4 5 6  
 * */
public class Solution {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		sc.nextLine();
//		int[] ar = new int[n];
//		for(int i=0;i<n;i++){
//			ar[i] = sc.nextInt();
//		}
		int n = 6;
		int[] ar = {1,4,3,5,6,2};
		
		insertionSortPart2(ar);
		
//		printArr(ar);
		sc.close();
	}
	private static void printArr(int[] ar){
		for(int n : ar){
			System.out.print(n+" ");
		}
		System.out.println();
	}
	
	private static void insertionSortPart2(int [] ar){
		int z = 0;
		int len = ar.length;
		for(int i=1;i<len;i++){
			
			z = ar[len-1];
			ar[len-1] = ar[i];
			ar[i] = z;
			insertionSortPart1(ar);
			printArr(ar);			
		}
	}
	
	private static int[] insertionSortPart1(int[] ar){
		int len = ar.length;
		int v = ar[ar.length-1];
		//COMMENT: if array size equal 1 : do nothing
		if(len == 1){
			return ar;
		}else{
			//COMMENT: if v greater or equal to the right element ( ar[len-1] ) : do nothing
			for(int i = len-2;v < ar[len -2] && i >= 0;i-- ){
				//COMMENT: if v less than element ar[i],  put element right ar[i+1] = ar[i]
				if(v <= ar[i]){
					ar[i+1] = ar[i];
					
					//COMMENT: if there are no more element to compare, put first element = v 
					if(i == 0){
						ar[i] = v;
					}
				}else{
					//COMMENT: if v greater than element ar[i], put v on right of element ar[i]
					ar[i+1] = v;
					break;
				}
			}
		}	
		return ar;
	}
	

}
