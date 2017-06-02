package mfi.old_packages.thread.ex4_guardedBlockExample;

//In this example, the data is a series of a text message, which are shared through an object of type Drop	
public class Drop {
	// message sent from producer to consumer
	private String message;
	
	// True if consumer should wait for producer to send message,
	// False if produced should wait for consumer to retrieve message
	private boolean empty = true;
	
	public synchronized String take(){
		// Wait until message is available
		while(empty){
			try{
				wait();
			}catch(InterruptedException ie){
				
			}
		}
		
		// Toggle status.
		empty = true;
		// Notify producer that status has changed.
		notifyAll();
		
		return message;
	}
	
	public synchronized void put(String message){
		// wait until message has been retrieved.
		while(!empty){
			try{
				wait();
			}catch(InterruptedException ie){}
		}
		// Toggle status.
		empty = false;
		// Notify consumer that status has changed.
		notifyAll();
	}
	
	
}
