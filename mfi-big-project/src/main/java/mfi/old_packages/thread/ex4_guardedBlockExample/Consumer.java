package mfi.old_packages.thread.ex4_guardedBlockExample;

import java.util.Random;

/*
 The consumer thread, defined in Consumer, simply retrieves the messages and prints them out, until
 it retrieves the "DONE" string. 
 This thread also pauses for random intervals 
 */
public class Consumer implements Runnable{
	private Drop drop;
	public Consumer(Drop drop){
		this.drop = drop;
	}
	
	public void run(){
		Random random = new Random();
		for(String message =  drop.take(); !"DONE".equals(message); message = drop.take()){
			System.out.format("MESSAGE RECEIVED: %s%n", message);
			try{
				Thread.sleep(random.nextInt(2000));
			}catch(InterruptedException ie){}
		}
	}
	

}
