package mfi.old_packages.thread.ex4_guardedBlockExample;

import java.util.Random;

/*
 The producer thread, defined in Producer, sends a series of familiar messages.
 The string "DONE" indicates that all messages have been sent. 
 To simulate the unpredictable nature of real-word applications,
 the producer thread pauses for random intervals between messages 
 */
public class Producer implements Runnable{
	private Drop drop;
	public Producer(Drop drop){
		this.drop = drop;
	}
	
	public void run(){
		String importantInfo[] = {"Hi this is miled","trying to learn thread","guardedBlock example","with a ConsumerProducer example"};
		Random random = new Random();
		for(int i=0;i<importantInfo.length;i++){
			drop.put(importantInfo[i]);
			try{
				Thread.sleep(random.nextInt(2000));
			}catch(InterruptedException ie){}
		}
		drop.put("DONE");
	}
	

}
