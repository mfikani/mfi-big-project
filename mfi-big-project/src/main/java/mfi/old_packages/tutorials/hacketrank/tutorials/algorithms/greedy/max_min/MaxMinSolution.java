package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.greedy.max_min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 url : https://www.hackerrank.com/challenges/angry-children?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 
 Given a list of  integers, your task is to select  integers from the list such that its unfairness is minimized.

if  are  numbers selected from the list , the unfairness is defined as

where max denotes the largest integer among the elements of , and min denotes the smallest integer among the elements of .

Input Format 
The first line contains an integer . 
The second line contains an integer . 
 lines follow. Each line contains an integer that belongs to the list .

Note: Integers in the list  may not be unique.

Output Format 
An integer that denotes the minimum possible value of unfairness.

Constraints 
 
 

Sample Input #00

7
3
10
100
300
200
1000
20
30
Sample Output #00

20
Explanation #00 
Here ; selecting the  integers such that  = , unfairness equals

max(10,20,30) - min(10,20,30) = 30 - 10 = 20
Sample Input #01

10
4
1
2
3
4
10
20
30
40
100
200
Sample Output #01

3
Explanation #01 
Here ; selecting the  integers , unfairness equals

max(1,2,3,4) - min(1,2,3,4) = 4 - 1 = 3
Sample Input #02

6
3
10
20
30
100
101
102
Sample Output #02

2
Explanation #02

Here ; the  integers so that the difference between the maximum and the minimum is the smallest are , which means unfairness equals

max(100, 101, 102) - min(100, 101, 102) = 102 - 100 = 2 
 * */
public class MaxMinSolution {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[] list = new int[N];

		for(int i = 0; i < N; i ++)
			list[i] = Integer.parseInt(in.readLine());

		int unfairness = Integer.MAX_VALUE;
		Arrays.sort(list);
		int diff = unfairness;
		for(int i=0;i+K-1<N;i++){
			if(diff > (list[i+K-1] - list[i])){
				diff = list[i+K-1] - list[i];
			}
		}
		unfairness = diff;
//		System.out.println(diff);
		
		/*
		 * Write your code here, to process numPackets N, numKids K, and the packets of candies
		 * Compute the ideal value for unfairness over here
		 */

		System.out.println(unfairness);
	}
}
