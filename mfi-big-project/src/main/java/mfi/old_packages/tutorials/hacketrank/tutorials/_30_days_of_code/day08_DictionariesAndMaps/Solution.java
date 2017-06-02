package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day08_DictionariesAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	
	/*
	 input : 
	3
	sam 99912222
	tom 11122222
	harry 12299933
	sam
	edward
	harry
	
	 output :  
	sam=99912222
	Not found
	harry=12299933
	 * */
	public static void main(String[] args){
		   Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        Map<String,Integer> myMap = new HashMap<String,Integer>(); 
	        for(int i = 0; i < n; i++){
	            String name = in.next();
	            int phone = in.nextInt();
	            in.nextLine();
	            myMap.put(name, phone);
	        }
	        while(in.hasNext()){
	            String s = in.next();
	            if(myMap.get(s) == null)
	                System.out.println("Not found");
	            else {
	                System.out.println(s + "=" + myMap.get(s));
	            }
	        }
	        in.close();
		
	}
		/*Scanner sc = new Scanner(System.in);
		Map m = new HashMap();
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++){
			String s  = sc.nextLine();
			String[] ar2 = s.split(" ");
			m.put(ar2[0], ar2[1]);
		}
		while(sc.hasNext()){
			String s = sc.nextLine();
			System.out.println(m.get(s)==null?"Not Found":s+"="+m.get(s));
			
		}
		
		sc.close();
		
	}*/
}
