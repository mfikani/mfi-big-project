package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.implementation.extra_long_factorials;

import java.math.BigInteger;
import java.util.Scanner;
/*
 N! = N x (N-1) x ... 3 x 2 x 1
  
 * */
public class ExtraLongFactorialsSolution {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        BigInteger b = factorialN(n);
        System.out.println(b+"\n"+Integer.MAX_VALUE+"\n"+b.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)));
//        for(int i=1;i<=5;i++){
//        	System.out.println("Factorial "+i+" = "+factorialN(i));
//        }
    }
	private static BigInteger factorialN (int n){
		BigInteger b =BigInteger.valueOf(1);
	     for(Integer i=1;i<=n;i++){
	    	 b=b.multiply(BigInteger.valueOf(i));
	     }
	     System.out.println(b);
	     return b;
	}

}
