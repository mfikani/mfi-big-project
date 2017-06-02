package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.minimumdistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
Sample Input
6
7 1 3 4 1 7

Sample Output
3
 
 * */

public class MinimumDistanceSolution {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] A = new int[n];
			HashMap hm = new HashMap();
			ArrayList lst_i = new ArrayList();
			int min = Integer.MAX_VALUE;
			boolean minExists = false;
			for(int A_i=0;A_i<n;A_i++){
//				lst_i = new ArrayList();
//				h.put(A[A_i], lst_i);
				A[A_i] = sc.nextInt();
				if(hm.containsKey(A[A_i])){
					minExists = true;
					lst_i = (ArrayList)hm.get(A[A_i]);
					lst_i.add(A_i);
					hm.put(A[A_i], lst_i);
				}else{
					lst_i = new ArrayList();
					lst_i.add(A_i);
					hm.put(A[A_i],lst_i );
				}			
			}
			sc.close();
			
			Set keySet = hm.keySet();
			Iterator iter = keySet.iterator(); 
			while(iter.hasNext()){
				int key = (int)iter.next();
				lst_i = (ArrayList)hm.get(key);
				int temp = (int)lst_i.get(0);
				if(lst_i != null && lst_i.size() > 1){
					for(int j=1;j<lst_i.size();j++){
						if(Math.abs(temp - (int)lst_i.get(j)) < min){
							min = Math.abs(temp - (int)lst_i.get(j));
						}
					}
				}
			}
			System.out.println(minExists? min:"-1");

	}

}
