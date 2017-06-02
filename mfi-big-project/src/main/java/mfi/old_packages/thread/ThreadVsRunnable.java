package mfi.old_packages.thread;

/*
 Differences between extending Thread or implementing Runnable interface :  
1- When you extend Thread class, you can�t extend any other class which you require. (As you know, Java does not allow inheriting more than one class). 
   When you implement Runnable, you can save a space for your class to extend any other class in future or now.

However, the significant difference is.

2- When you extends Thread class, each of your thread creates unique object and associate with it. When you implements Runnable, 
   it shares the same object to multiple threads.
  
 * */

class ImplementsRunnable implements Runnable{
	private int counter = 0;
	
	public void run(){
		counter++;
		System.out.println("ImplementsRunnable : Counter : "+counter);
	}
}

class ExtendsThread extends Thread{
	private int counter = 0;
	
	public void run(){
		counter++;
		System.out.println("ExtendsThread : Counter : " + counter);
	}
}

public class ThreadVsRunnable{
	public static void main(String args[])throws Exception{
		// Multiple threads share the same object.
		ImplementsRunnable rc = new ImplementsRunnable();
		Thread t1 = new Thread(rc);
		t1.start();
		Thread.sleep(1000);// waiting for 1 second before starting next thread
		Thread t2 = new Thread(rc);
		t2.start();
		Thread.sleep(1000);// waiting for 1 second before starting next thread
		Thread t3 = new Thread(rc);
		t3.start();
		
		// Creating new instance for every thread access
		ExtendsThread tc1 = new ExtendsThread();
		tc1.start();
		Thread.sleep(1000);// waiting for 1 second before starting next thread
		ExtendsThread tc2 = new ExtendsThread();
		tc2.start();
		Thread.sleep(1000);// waiting for 1 second before starting next thread
		ExtendsThread tc3 = new ExtendsThread();
		tc3.start();
	}
}