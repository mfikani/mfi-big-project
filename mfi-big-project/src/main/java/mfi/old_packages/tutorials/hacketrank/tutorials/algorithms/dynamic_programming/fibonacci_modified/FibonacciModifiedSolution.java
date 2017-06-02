package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.dynamic_programming.fibonacci_modified;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModifiedSolution {

/*
 * t (i+2) = t(i)+pow([t(i+1)],2)
 * 
Sample Input

0 1 5
Sample Output

5 
 * */	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		BigInteger t0 = new BigInteger(sc.next());
		BigInteger t1 = new BigInteger (sc.next());
		BigInteger n = new BigInteger (sc.next());
		BigInteger ti;
		for(int i=2;i<n.intValue();i++){
			ti = t0.add(t1.pow(2));
			t0 = t1;
			t1 = ti;
		}
		System.out.println(t1);
		sc.close();

	}
	
	

}
