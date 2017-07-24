package mfi.tech.java.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * 
 url : https://www.tutorialspoint.com/java/java_serialization.htm 
 * 
 note : 
 Note − When serializing an object to a file, the standard convention in Java is to give the file a .ser extension.
  
 * */
public class SerializeDemo {

	public static void main(String [] args) {
	      Employee e = new Employee();
	      e.name = "Reyan Ali";
	      e.address = "Phokka Kuan, Ambehta Peer";
	      e.SSN = 11122333;
	      e.number = 101;
	      
	      try {
	    	  
	    	 String srcFolder = System.getProperty("user.dir");
       		 String testingFile = srcFolder+"\\src\\main\\resources\\generated\\Employee.ser"; 
	    	  
	         FileOutputStream fileOut = new FileOutputStream(testingFile);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(e);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in "+testingFile);
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	   }
}
