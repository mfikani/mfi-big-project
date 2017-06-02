package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day04_ClassesVsInstances;

import java.util.Scanner;
/*
 Input : 
 4
-1
10
16
18 
 
 Output : 
Age is not valid, setting age to 0.
You are young.
You are young.

You are young.
You are a teenager.

You are a teenager.
You are old.

You are old.
You are old.
 
 * */
public class Person {
	private int age;
	
	public Person(int initialAge){
		// Add some more codes to run some checks on initialAge 
		if(initialAge >= 0){
			this.age = initialAge;
		}else{
			System.out.println("Age is not valid, setting age to 0.");
			this.age = 0;
		}
	}
	
	public void amIOld(){
		// Write code determining if this person's age is old and print the correct statement:
		String result = "";
		if(this.age < 13){
			result = "You are young.";
		}else if(13 <= age && age < 18){
			result = "You are a teenager.";
		}else{
			result = "You are old.";
		}
		System.out.println(result);
	}
	
	public void yearPasses(){
		// Increment the person's age
		this.age++;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for( int i = 0; i < T; i++){
			int age = sc.nextInt();
			Person p = new Person(age);
			p.amIOld();
			for(int j = 0;j<3; j++){
				p.yearPasses();
			}
			p.amIOld();
			System.out.println();
		}		
		sc.close();
	}
	

}
