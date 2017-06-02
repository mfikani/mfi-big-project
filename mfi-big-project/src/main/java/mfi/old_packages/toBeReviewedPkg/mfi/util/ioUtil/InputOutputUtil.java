package mfi.old_packages.toBeReviewedPkg.mfi.util.ioUtil;

import java.util.Scanner;

public class InputOutputUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static void printArray(int[] ar){
		for(int x : ar){
			System.out.print(x+" ");
		}
		System.out.println();
	}
	public static int[] readArray(int l, Scanner in){
		//in.nextLine();
		int[] res = new int[l];
		for(int i=0;i<l;i++){
			res[i] = in.nextInt();
		}
		return res;
	}
}
