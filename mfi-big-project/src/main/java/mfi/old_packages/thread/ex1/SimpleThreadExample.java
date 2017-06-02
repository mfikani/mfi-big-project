package mfi.old_packages.thread.ex1;

public class SimpleThreadExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String importantInfo[] = {
	            "Mares eat oats",
	            "Does eat oats",
	            "Little lambs eat ivy",
	            "A kid will eat ivy too"
	        };
		
		for (int i = 0; i < importantInfo.length; i++) {
            //Pause for 2 seconds
            Thread.sleep(2000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
		
	}

}
