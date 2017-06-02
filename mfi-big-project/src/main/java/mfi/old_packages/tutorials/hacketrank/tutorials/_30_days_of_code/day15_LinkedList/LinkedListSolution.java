package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day15_LinkedList;

import java.util.Scanner;

public class LinkedListSolution {

	/*
	 * URL : https://www.hackerrank.com/challenges/30-linked-list
	 * 
	 Sample Input

	The following input is handled for you by the locked code in the editor: 
	The first line contains T, the number of test cases. 
	The  subsequent lines of test cases each contain an integer to be inserted at the list's tail.
	
	4
	2
	3
	4
	1
	Sample Output
	
	The locked code in your editor prints the ordered data values for each element in your list as a single line of space-separated integers:
	
	2 3 4 1 
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Node head = null;
		int N = sc.nextInt();
		while(N-- > 0){
			int ele = sc.nextInt();
			
			//sc.nextLine();
			head = insert(head,ele);
		}
		display(head);
		sc.close();
	}

	public static void display(Node head){
		Node start = head;
		while(start != null){
			System.out.print(start.data+" ");
			start = start.next;
		}
	}
	
	public static Node insert(Node head, int data){
		if(head == null){
			head= new Node(data);
		}else{
			Node start = head;
			while(start.next != null){
				start = start.next;
			}
			start.next = new Node(data);
		}
		return head;
	}
}
class Node{
	int data;
	Node next;
	Node(int d){
		data = d;
		next = null;
	}
}