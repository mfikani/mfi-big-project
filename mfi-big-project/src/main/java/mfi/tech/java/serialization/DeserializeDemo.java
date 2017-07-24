package mfi.tech.java.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {

	public static void main(String [] args) {
	      Employee e = null;
	      try {
	    	 String srcFolder = System.getProperty("user.dir");
	       	 String testingFile = srcFolder+"\\src\\main\\resources\\generated\\Employee.ser"; 
	       		 
	         FileInputStream fileIn = new FileInputStream(testingFile);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Employee) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i) {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      
	      System.out.println("Deserialized Employee...");
	      System.out.println("Name: " + e.name);
	      System.out.println("Address: " + e.address);
	      System.out.println("SSN: " + e.SSN+"\t (not serializable because it is declarated transient)");
	      System.out.println("Number: " + e.number);
	   }
}
