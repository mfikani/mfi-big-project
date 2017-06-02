package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day12_Inheritance;

import java.util.Scanner;

public class Day12_InheritanceSolution {

	/*
	 Sample Input

	Heraldo Memelli 8135627
	2
	100 80
	Sample Output
	
	 Name: Memelli, Heraldo
	 ID: 8135627
	 Grade: O 
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String firstName = sc.next();
		String lastName = sc.next();
		int id = sc.nextInt();
		int numScores = sc.nextInt();
		int[] testScores = new int[numScores];
		for(int i=0;i<numScores;i++){
			testScores[i] = sc.nextInt();
		}
		sc.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: "+s.calculate());
		

	}

}
