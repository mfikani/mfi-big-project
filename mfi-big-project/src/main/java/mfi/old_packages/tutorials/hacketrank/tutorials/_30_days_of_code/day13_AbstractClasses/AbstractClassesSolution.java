package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day13_AbstractClasses;

import java.util.Scanner;
/*
Output Format

The  method should print and label the respective , , and  of the MyBook object's instance (with each value on its own line) like so:

Title: $title
Author: $author
Price: $price
Note: The  is prepended to variable names to indicate they are placeholders for variables.

Sample Input

The following input from stdin is handled by the locked stub code in your editor:

The Alchemist
Paulo Coelho
248 
 * */
public class AbstractClassesSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String title = sc.nextLine();
		String author = sc.nextLine();
		int price = sc.nextInt();
		Book new_novel = new MyBook(title,author,price);
		new_novel.display();
		sc.close();
	}

}

