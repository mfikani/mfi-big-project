package mfi.old_packages.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/***
 * Reference : http://java2novice.com/java-collections-and-util/linkedlist/
 * @author miled 
 *
 */
public class LinkedListSample {
	
	public static void main(String[] args){
		LinkedList<String> lk = new LinkedList<String>();
		lk.add("Orange");
		lk.add("Apple");
		lk.add("Grape");
		lk.add("Banana");
		System.out.println(lk);
		
		/*
		 * basic operations : 
		  	- like creating object for LinkedList, 
		  	- adding objects into LinkedList, 
		  	- searching an object in LinkedList, whether it is listed under this LinkedList instance or not, 
		  	- checking whether the LinkedList is empty or not, 
			- finally size of the LinkedList.	
		 * */
		System.out.println("************** basicOperations *****************");
		basicOperations(lk);
		System.out.println("------------------------------------------------");
		System.out.println("************** linkedListIterate ***************");
		linkedListIterate(lk);
		System.out.println("------------------------------------------------");
		System.out.println("**************** linkedListClone ***************");
		linkedListClone(lk);
		System.out.println("------------------------------------------------");
		System.out.println("**************** linkedListAddAll **************");
		linkedListAddAll(lk);
		System.out.println("------------------------------------------------");
		System.out.println("**************** linkedListDeleteAll ***********");
		linkedListDeleteAll(lk);
		System.out.println("------------------------------------------------");
		System.out.println("**************** linkedListContainsAll *********");
		linkedListContainsAll(lk);
		System.out.println("------------------------------------------------");
		System.out.println("**************** linkedListToArray *************");
		linkedListToArray(lk);
		System.out.println("------------------------------------------------");
		System.out.println("**************** linkedListToArray *************");
		linkedListToArray(lk);
		System.out.println("------------------------------------------------");
		
	}
	private static void linkedListToArray(LinkedList lk){
		System.out.println("Actual LinkedList : "+lk);
		String[] array = new String[lk.size()];
		lk.toArray(array);
		System.out.println("array : "+array);
		for(Object st : array){
			System.out.println(st);
		}
	}
	private static void linkedListContainsAll(LinkedList lk){
		System.out.println("Actual LinkedList : "+lk);
		List lt = new ArrayList();
		lt.add("Grape");
		lt.add("miled");
		System.out.println("collection : "+lt);
		System.out.println("Contains All, LinkedList : "+lk.containsAll(lt));
	}
	private static void linkedListDeleteAll(LinkedList lk){
		LinkedList lkTemp = new LinkedList();
		lkTemp.addAll(lk);
		System.out.println("Actual LinkedList : "+lkTemp);
		lkTemp.clear();
		System.out.println("After delete All, LinkedList : "+lkTemp);
	}
	private static void linkedListAddAll(LinkedList lk){
		System.out.println("Actual LinkedList : "+lk);
		List lt = new ArrayList();
		lt.add("miled");
		lt.add("fikani");
		lk.addAll(lt);
		System.out.println("After add All, LinkedList : "+lk);
	}
	private static void linkedListClone(LinkedList lk){
		System.out.println("Actual LinkedList : "+lk);
		LinkedList<String> cl = new LinkedList<String>();
		cl = (LinkedList<String>)lk.clone();
		System.out.println("Cloned LinkedList : "+cl);
	}
	private static void linkedListIterate(LinkedList lk){
		Iterator it = lk.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	private static void basicOperations(LinkedList lk){	
		System.out.println("First["+lk.getFirst()+"]");
		System.out.println("third 3 element["+lk.get(3-1)+"]");
		System.out.println("Last["+lk.getLast()+"]");
		System.out.println("is Empty : ["+lk.isEmpty()+"]");
		System.out.println("Size["+lk.size()+"]");
		System.out.println("Does LinkedList contains 'Grape'? "+lk.contains("Grape"));
		
	}
}
