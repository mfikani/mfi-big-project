package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day12_Inheritance;

public class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	Person(String firstName, String lastName, int identificationNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identificationNumber;
	}
	public void printPerson(){
		System.out.println("Name: "+this.lastName+", "+this.firstName+"\nID: "+this.idNumber);
		
	}
}
