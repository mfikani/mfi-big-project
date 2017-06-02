package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.implementation.beautiful_triplets;

import java.util.Scanner;

/*
 https://www.hackerrank.com/challenges/beautiful-triplets?h_r=next-challenge&h_v=zen
 
  Erica wrote an increasing sequence of  numbers () in her notebook. She considers a triplet  to be beautiful if:

Given the sequence and the value of , can you help Erica count the number of beautiful triplets in the sequence?

Input Format

The first line contains  space-separated integers,  (the length of the sequence) and  (the beautiful difference), respectively. 
The second line contains  space-separated integers describing Erica's increasing sequence, .

Constraints

 for 
Output Format

Print a single line denoting the number of beautiful triplets in the sequence.

Sample Input

7 3
1 2 4 5 7 8 10
Sample Output

3
Explanation

Our input sequence is , and our beautiful difference . There are many possible triplets , but our only beautiful triplets are (1,4,7) , (4,7,10) and (2,5,8). Please see the equations below:


Recall that a beautiful triplet satisfies the following equivalence relation:  where .
 * */
public class BeautifulTripletsSolution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int d = sc.nextInt();
		sc.nextLine();
		int[] ar = new int[p];
		for(int i=0;i<ar.length;i++){
			ar[i] = sc.nextInt();
		}
		int count = 0;
		for(int i=0;i<ar.length-2d;i++){
			for(int j=1;j<ar.length;j++){
				if(ar[j] - ar[i] == d){
					for(int k=2;k<ar.length;k++){
						if(ar[k] - ar[j] == d){
							count++;
							System.out.println(ar[i]+" "+ar[j]+" "+ar[k]);
						}						
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}

}
