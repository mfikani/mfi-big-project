package mfi.old_packages.tutorials.hacketrank.dashboard.java.big_number.java_big_integer;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {
/*
 url: https://www.hackerrank.com/challenges/java-biginteger
 Sample Input

1234
20
Sample Output

1254
24680
  
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String i1 = sc.next();
		String i2 = sc.next();
		
		BigInteger bi1 = new BigInteger(i1);
		BigInteger bi2 = new BigInteger(i2);
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.multiply(bi2));
		sc.close();
	}

}
