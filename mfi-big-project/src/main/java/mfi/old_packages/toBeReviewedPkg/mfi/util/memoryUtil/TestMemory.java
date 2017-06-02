package mfi.old_packages.toBeReviewedPkg.mfi.util.memoryUtil;

import java.util.ArrayList;
import java.util.List;

public class TestMemory {

	public static void main(String [] args) {
		
		//meth1();
		
		meth2();
//		Runtime runtime1 = Runtime.getRuntime();
//		System.out.println("Free memory in MB : "+runtime1.freeMemory()/(1024*1024));
		//int[] A = new int[10000000];
		List lt = new ArrayList(); 
		OneMegaByte obj;
		for(int i=0;i<100;i++){
			obj = new OneMegaByte();
			lt.add(obj);
			Runtime.getRuntime().gc();
			System.out.println("i:"+i);
			meth2();
		}
//		Runtime runtime2 = Runtime.getRuntime();
//		System.out.println("Free memory in MB : "+runtime2.freeMemory()/(1024*1024));
		
	}
	
	private static void meth2(){
		int mb = 1024;
		//Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("##### Heap utilization statistics [MB] #####");
		
		//Print used memory
		System.out.println("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / mb);

		//Print free memory
		System.out.println("Free Memory:" + runtime.freeMemory() / mb);
		
		//Print total available memory
		System.out.println("Total Memory:" + runtime.totalMemory() / mb);

		//Print Maximum available memory
		System.out.println("Max Memory:" + runtime.maxMemory() / mb);
	}
	private static void meth1(){
		/*
			1 kB = 1024 bytes
		  , 1 MB = 1024 kB
		  , 1 GB = 1024 MB
		  , 1 TB = 1024 GB
		  
	 * */
	
	int onebyte 	= 1;
	int oneKilobyte = onebyte * 1024;
	int oneMegabyte	= oneKilobyte * 1024;
	int oneGegabyte = oneMegabyte * 1024;
	int oneTerrabyte= oneGegabyte * 1024; 
	

	System.out.println(onebyte);
	System.out.println(oneKilobyte);
	System.out.println(oneMegabyte);
	System.out.println(oneGegabyte);
	System.out.println(oneTerrabyte);
	
	//Getting the runtime reference from system
	Runtime runtime = Runtime.getRuntime();

	System.out.println("##### Heap utilization statistics [MB] #####");
	printMemory(runtime, oneMegabyte);
	
	System.out.println("\n##### Heap utilization statistics [KB] #####");
	printMemory(runtime, oneKilobyte);
	
	System.out.println("\n##### Heap utilization statistics [byte] #####");
	printMemory(runtime, onebyte);
	}
	private static void printMemory(Runtime runtime, int unitType){
		//Print used memory
		System.out.println("Used Memory:" 
				+ (runtime.totalMemory() - runtime.freeMemory()) / unitType);

		//Print free memory
		System.out.println("Free Memory:" 
				+ runtime.freeMemory() / unitType);

		//Print total available memory
		System.out.println("Total Memory:" + runtime.totalMemory() / unitType);

		//Print Maximum available memory
		System.out.println("Max Memory:" + runtime.maxMemory() / unitType);
	}
}
class OneMegaByte{
	private int buff[]; 
	OneMegaByte(){
		// approximately one mega byte
		this.buff = new int[1024 * 1024];
	}
}