package mfi.old_packages.tutorials.hacketrank.dashboard.java.introduction.java_currency_formatter;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 url : https://www.hackerrank.com/challenges/java-currency-formatter?h_r=next-challenge&h_v=zen
 
Sample Input

12324.134
Sample Output

US: $12,324.13
India: Rs.12,324.13
China: ￥12,324.13
France: 12 324,13 €


----------------------------
Sample Input

0.999
Sample Output

US: $1.00
India: Rs.1.00
China: ï¿¥1.00
France: 1,00 â‚¬



 * */

public class JavaCurrencyFormatter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);
	        double payment = scanner.nextDouble();
	        scanner.close();
	        
	        // Write your code here.
	        
	        String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
	        String india = NumberFormat.getCurrencyInstance(new Locale("EN", "IN")).format(payment);
	        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
	        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);
	        
	        System.out.println("US: " + us);
	        System.out.println("India: " + india);
	        System.out.println("China: " + china);
	        System.out.println("France: " + france);
	}

}
