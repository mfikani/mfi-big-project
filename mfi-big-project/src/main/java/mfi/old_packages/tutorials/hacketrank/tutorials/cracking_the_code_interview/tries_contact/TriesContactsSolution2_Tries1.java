package mfi.old_packages.tutorials.hacketrank.tutorials.cracking_the_code_interview.tries_contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 URL : https://www.hackerrank.com/challenges/ctci-contacts?h_r=next-challenge&h_v=zen
 
  Tries: Contacts 
by dcod5
Problem
Submissions
Leaderboard
Discussions
Editorial
Check out the resources on the page's right side to learn more about tries. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.
We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

We perform the following sequence of operations:

Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.
 * */
public class TriesContactsSolution2_Tries1 {

	 static class TrieNode{
	        // No. of contacts possible after reaching this node in the trie
	        int noOfContacts = 0;
	        // Next characters in the 26-ary trie
	        TrieNode[] children = new TrieNode[26];
	        
	        void add(String s){
	            TrieNode current = this; // Begin with the current node and start adding each character
	            for(int i = 0; i < s.length(); i++){
	                int index = s.charAt(i) - 'a';
	                if(current.children[index] == null){
	                    current.children[index] = new TrieNode();
	                }
	                current.noOfContacts++;
	                current = current.children[index];
	            }
	            current.noOfContacts++; // Leaf node should have count 1
	        }
	        
	        int search(String val){
	            TrieNode current = this; // Begin search from the current node
	            for(int i = 0; i < val.length(); i++){
	                int index = val.charAt(i) - 'a';
	                current = current.children[index];
	                if(current == null){
	                    break;
	                }
	            }
	            return (current == null)? 0 : current.noOfContacts;
	        }
	    }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        long A = System.currentTimeMillis();
	        TrieNode root = new TrieNode();
	        for(int a0 = 0; a0 < n; a0++){
	            String op = in.next();
	            String contact = in.next();
	            if(op.equals("add")){
	                root.add(contact);
	            }
	            else{
	                System.out.println(root.search(contact));
	            }
	        }
	        System.out.println("Time : "+(System.currentTimeMillis() - A));
	    }
}
