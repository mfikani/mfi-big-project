package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day01_DataTypes;

import java.util.Scanner;

public class DataTypesSolution {

	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank";
		
		Scanner scan = new Scanner(System.in);
		
		/* Declare second integer, double and String variables. */
		int i2 = 0;
		double d2 = 0;
		String s2;
		
		/* Read and save an integer, double and String to your variables.*/
		System.out.println("Please enter an integer : ");
		i2 = scan.nextInt();
		
		System.out.println("Please enter a double : ");
		d2 = scan.nextDouble();
		
		scan.nextLine();
		System.out.println("Please enter a String : ");
		s2 = scan.nextLine();
		
		/* Print the sum of the both integer variables on a new line. */
		System.out.println(i + i2);
		System.out.println(d + d2);
		
		/* Concatenate and print the String variables on a new line;
		 * the 's' variable above should be printed first. */
		System.out.println(s +" "+ s2);
		
		
		scan.close();

	}

}
