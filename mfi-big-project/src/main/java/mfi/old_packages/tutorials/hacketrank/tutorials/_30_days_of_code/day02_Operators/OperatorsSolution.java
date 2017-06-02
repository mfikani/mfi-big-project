package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day02_Operators;

import java.util.Scanner;

public class OperatorsSolution {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		double mealCost = scan.nextDouble(); // original meat price
		int tipPercent = scan.nextInt(); // tip percentage
		int taxPercent = scan.nextInt(); // tax percentage
		scan.close();
		
		// Write your calculation code here
		double tip = mealCost * ((double)tipPercent / 100);
		double tax = mealCost * ((double)taxPercent / 100);
		double cost = tip + tax + mealCost;
		
		// cast the result of the rounding operation to an int and save it in totalCost
		int totalCost = (int)Math.round(cost);
		
		// Print the result
		System.out.println("The total meal cost is "+totalCost+" dollars.");
	}
}
