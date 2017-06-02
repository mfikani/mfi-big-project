package mfi.old_packages.tutorials.hacketrank.dashboard.algorithms.implementation.sock_merchant;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SockMerchant {
/*
 https://www.hackerrank.com/challenges/sock-merchant
 
  Sample Input

9
10 20 20 10 10 30 50 10 20
Sample Output

3


 * */
	public static void main(String[] args) {
		//doTest1();
		doTest2();
	}
	private static void doTest2(){
		 Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int c[] = new int[n];
	        for(int c_i=0; c_i < n; c_i++){
	            c[c_i] = in.nextInt();
	        }
	        int pairs = 0;
	        Set<Integer> backendSet = new TreeSet<>();
	        //ArrayList backendSet = new ArrayList();  // ArrayList wont work cz ArrayList.remove(index) it remove based on the index not value

	        for (int cc : c) {
	            if (backendSet.contains(cc)) {
	                pairs++;
	                backendSet.remove(cc);
	            }
	            else {
	                backendSet.add(cc);
	            }
	        }

	        System.out.println(pairs);
	}
	private static void doTest1(){
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        HashMap hm = new HashMap();
        int nb = 0;
        int count = 0;
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
            if(hm.get(c[c_i]) != null){
            	nb = (int) hm.get(c[c_i]);
            	hm.put(c[c_i],nb+1);
            }else{
            	hm.put(c[c_i],1);
            }
        }
        
        Collection lt = (Collection) hm.values();
        Iterator iter = lt.iterator();
        while(iter.hasNext()){
        	int h = (int)iter.next();
        	count += h/2;
        }
       
        System.out.println(count);
        in.close();

	}

}
