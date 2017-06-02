package mfi.old_packages.tutorials.hacketrank.dashboard.algorithms.implementation.min_max_sum;

import java.util.ArrayList;
import java.util.Scanner;

public class MinMaxSum {
/*
 https://www.hackerrank.com/challenges/mini-max-sum
 
  Sample Input

1 2 3 4 5
Sample Output

10 14


 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	        long a = in.nextLong();
	        long b = in.nextLong();
	        long c = in.nextLong();
	        long d = in.nextLong();
	        long e = in.nextLong();
	        
	        ArrayList lt = new ArrayList();
	        lt.add(a);
	        lt.add(b);
	        lt.add(c);
	        lt.add(d);
	        lt.add(e);  
	        long min = 0; long max = 0;
	        long sum = 0;
	        for(int i =0;i<lt.size();i++){
	           sum = 0;
	            for(int j=0;j<lt.size();j++){
	                if(i != j ){
	                    sum += (long)lt.get(j);
	                }
	            }
	            if(i == 0){
	                min = sum;
	                max = sum;
	            }else{
	                if(min > sum){
	                    min = sum;
	                }
	                if(max < sum){
	                    max = sum;
	                }
	            }            
	        }
	        System.out.println(min+" "+max);

	}

}
