package mfi.tech.java.array.AlgorithmicCrush;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AlgorithmicCrushSolution {

/*
url : https://www.hackerrank.com/challenges/crush?h_r=next-challenge&h_v=zen

Sample Input
5 3
1 2 100
2 5 100
3 4 100

Sample output
200

explanation :   
5 array of 5 elements initialized to 0 
3 perform 3 queries

After first update list will be 100 100 0 0 0. 
After second update list will be 100 200 100 100 100.
After third update list will be 100 200 200 200 100.
So the required answer will be 200.

 * */	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			String content = new String(Files.readAllBytes(Paths.get("D:/WORK/mfi-big-project/mfi-big-project/src/main/java/mfi/tech/java/array/AlgorithmicCrush/test-case/textcase1.txt")));
			System.out.println(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		
		BigInteger[] arr = new BigInteger[n];
		for(int i=0;i<arr.length;i++){
			arr[i] = BigInteger.ZERO;
		}
		printArr(arr);
		for(int i=0;i<q;i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int k = sc.nextInt();
			if(k != 0){
				for(int ii = a-1;ii <= b-1;ii++){
					arr[ii] = arr[ii].add(BigInteger.valueOf(k));
				}
			}
		}		
		sc.close();
		printArr(arr);
		System.out.println(getArrayMax(arr));
		 						
	}
	public static BigInteger getArrayMax(BigInteger[] arr){
		BigInteger max = arr[0];
		for(int i=1;i<arr.length;i++){
			if(max.compareTo(arr[i]) < 0){
				max = arr[i];
			}
		}
		return max;
	}
	public static void printArr(BigInteger[] n){
		for(BigInteger i: n){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
