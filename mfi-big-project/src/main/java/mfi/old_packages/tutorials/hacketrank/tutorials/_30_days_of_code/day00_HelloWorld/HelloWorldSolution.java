package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day00_HelloWorld;

import java.util.Scanner;

public class HelloWorldSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a Scanner object to read input from stdin.
		Scanner scan = new Scanner(System.in);
		
		// Read a full line of input from stdin and save it to our variable, inputString.
		String inputString = scan.nextLine();
		
		
		// Close the scanner object, because we've finished reading
		scan.close();
		
		// Print a string literal saying "Hello, World." to stdout.
		System.out.println("Hello, World.");
		
		// TODO: Write a line of code here that prints the contents of inputString to stdout.
		System.out.println(inputString);

	}

}
