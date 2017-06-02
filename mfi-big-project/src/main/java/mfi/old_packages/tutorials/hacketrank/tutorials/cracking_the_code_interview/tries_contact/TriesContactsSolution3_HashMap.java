package mfi.old_packages.tutorials.hacketrank.tutorials.cracking_the_code_interview.tries_contact;

import java.util.HashMap;
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
public class TriesContactsSolution3_HashMap {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long A = System.currentTimeMillis();
		HashMap<String, Integer> map = new HashMap<>();
		for(int a0 = 0; a0 < n; a0++){
			String op = in.next();
			String contact = in.next();
			if (op.equals("add")){

				for(int i=0; i<contact.length(); i++){
					if (map.containsKey(contact.substring(0, i+1))){
						map.put(contact.substring(0, i+1), map.get(contact.substring(0, i+1))+1);
					} else{
						map.put(contact.substring(0, i+1), 1);
					}
				}

			} else{
				if (map.containsKey(contact)){
					System.out.println(map.get(contact));
				} else{
					System.out.println(0);
				}
			}
		}
		System.out.println("Time : "+(System.currentTimeMillis() - A));
	} 
}
