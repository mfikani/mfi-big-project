package mfi.old_packages.thread.ex4_guardedBlockExample;


/*
 * Let's use guarded blocks to create a Producer-Consumer application. 
 * This kind of application shares data between two threads: the producer, that creates the data, 
 * and the consumer, that does something with it. 
 * The two threads communicate using a shared object. 
 * Coordination is essential: the consumer thread must not attempt to retrieve the data before the producer thread has delivered it, 
 * and the producer thread must not attempt to deliver new data if the consumer hasn't retrieved the old data.
 * 
 Finally, here is the main thread, defined in ProducerConsumerExample, that lunches the produer and consumer threads. 
 */
public class ProducerConsumerExample {
	public static void main(String[] args){
		Drop drop = new Drop();
		
		(new Thread(new Producer(drop))).start();
		(new Thread(new Consumer(drop))).start();
	}

}
