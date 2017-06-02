package mfi.old_packages.tutorials.hacketrank.all_contests.past._101_hack_41;

import java.util.Scanner;

import mfi.old_packages.toBeReviewedPkg.mfi.util.ioUtil.InputOutputUtil;

public class WashingPlates {

	/*
    Sample Input
	2 1
	10 5
	3 1
	Sample Output
	9 
	  
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        int n = 3;
        int k = 2;
        int[] p = {10,23,7};
        int[] d = {5,3,10};
//        for(int i=0;i<n;i++){
//        	p[i] = in.nextInt();
//        	d[i] = in.nextInt();
//        }
        System.out.println("Pay : ");
        InputOutputUtil.printArray(p);
        System.out.println("Deduction : ");
        InputOutputUtil.printArray(d);
        
        System.out.println(getTotalPayForOneK(n, p, d));
	}
	
	private static int getTotalPayForOneK(int n, int[] p, int[] d){
		 int tot = 0, pay = 0 , ded = 0, temp = 0,count = 0;
	        for(int i=0;i < n;i++){
	        	pay = getPay(i,p);
	        	ded = getDed(i,d);
	        	//System.out.println(i+": pay["+pay+"] and ded["+ded+"]");
	        	if(temp < getTotalPay(pay,ded)){
	        		temp = getTotalPay(pay,ded);
	        	}
	        }
	        //System.out.println(temp);
	        return temp;
	}
	private static int getPay(int ind, int[] ar){
		int sum = 0;
		for(int i=0;i<ar.length;i++){
			if(i != ind){
				sum += ar[i];
			}
		}
		return ar[ind];
	}
	private static int getDed(int ind, int[] ar){
		int sum = 0;
		for(int i=0;i<ar.length;i++){
			if(i != ind){
				sum += ar[i];
			}
		}
		return sum;
	}
	private static int getTotalPay(int p, int d){
		return (p-d)> 0 ? (p-d):0;
	}

}
