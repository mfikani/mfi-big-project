package mfi.old_packages.thread.ex2_simpleThreadExample;

public class SimpleThreads {
	// Display a message, preceded by 
	// the name of the current thread
	static void threadMessage(String message){
		String threadName = Thread.currentThread().getName();
		System.out.format("Thread[%s]: %s%n", threadName,message);
	}

	private static class MessageLoop implements Runnable{
		public void run(){
			String importantInfo[] = {"this is miled", "i am learning thread in java", "i hope to know it", "thank you"};
			
			try{
				for(int i=0;i<importantInfo.length;i++){
					// Pause 4 seconds 
					Thread.sleep(4000);
					// Print a message
					threadMessage(importantInfo[i]);
				}
			}catch(InterruptedException e){
				threadMessage("I wasn't done!");
			}
		}
	}
													
	public static void main(String[] args) throws InterruptedException{
		// delay in millisecond before 
		// we interrupt MessageLoop
		// thread (default one hour )
		long patience = 1000 * 60 * 60;
		
		// if command line argument
		// present, give patience  
		// in seconds
		if(args.length > 0){
			try{
				patience = Long.parseLong(args[0]) * 1000;
			}catch(NumberFormatException nfe){
				System.err.println("Arguments must be an integer.");
				System.exit(1);
			}
		}
		
		threadMessage("Starting MessageLoop thread");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		
		threadMessage("Waiting for MessageLoop thread to finish");
		// loop until MessageLoop
		// thread exits
		while(t.isAlive()){
			threadMessage("Still waiting ... ");
			// wait maximum of 1 second
			// for MessageLoop thread 
			// to finish
			t.join(7000);
			if(((System.currentTimeMillis() - startTime) > patience) && t.isAlive()){
				threadMessage("Tired of waiting!");
				t.interrupt();
				// shouldn't be long now 
				// -- wait indefinitely
				t.join();
			}
			
		}
		threadMessage("Finally!");
	}
}
