package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.implementation.acm_icpc_team;

import java.math.BigInteger;
import java.util.Scanner;

/*
 URL : https://www.hackerrank.com/challenges/acm-icpc-team?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 
  You are given a list of  people who are attending ACM-ICPC World Finals. Each of them are either well versed in a topic or they are not. Find out the maximum number of topics a 2-person team can know. And also find out how many teams can know that maximum number of topics.

Note Suppose a, b, and c are three different people, then (a,b) and (b,c) are counted as two different teams.

Input Format

The first line contains two integers,  and , separated by a single space, where  represents the number of people, and  represents the number of topics.  lines follow.
Each line contains a binary string of length . If the th line's th character is , then the th person knows the th topic; otherwise, he doesn't know the topic.

Constraints 
 

Output Format

On the first line, print the maximum number of topics a 2-person team can know. 
On the second line, print the number of 2-person teams that can know the maximum number of topics.

Sample Input

4 5
10101
11100
11010
00101
Sample Output

5
2
Explanation

(1, 3) and (3, 4) know all the 5 topics. So the maximal topics a 2-person team knows is 5, and only 2 teams can achieve this.
 * */
public class ACM_ICPC_Team_Solution {

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
	    int numOfPeople = scanner.nextInt();
	    int numOfTopics = scanner.nextInt();
	    BigInteger[] familiarity = new BigInteger[numOfPeople];
	    int maxBitCount = 0;
	    int maxScoreCount = 0;
	    BigInteger score;

	    for(int i=0; i<numOfPeople; i++) {
	        familiarity[i] = scanner.nextBigInteger(2);
	    }

	    for(int i=0; i<familiarity.length-1; i++) {
	        for(int j=i+1; j<=familiarity.length-1; j++) {
	            score = familiarity[i].or(familiarity[j]);
	            int bitCount = score.bitCount();
	            if(bitCount > maxBitCount) {
	                maxBitCount = bitCount;
	                maxScoreCount = 1;
	            } else if(bitCount == maxBitCount) {
	                maxScoreCount++;
	            }
	        }
	    }
	    System.out.println(maxBitCount);
	    System.out.println(maxScoreCount);
	}*/
		Scanner in = new Scanner(System.in);
		//System.out.println((char)48);
		int n = in.nextInt();
		int m = in.nextInt();
		int topics = 0; 
		int maxTopics = 0;
		int nb = 0;
		String topic[] = new String[n];
		for(int topic_i=0;topic_i < n;topic_i++){
			topic[topic_i] = in.next();
		}
		for(int topic_i=0;topic_i < n;topic_i++){
			for(int topic_j=topic_i+1;topic_j<n;topic_j++){
				if(topic_i != topic_j){
//					System.out.println(topic[topic_i]+ " and "+topic[topic_j]+ " : " );
					topics = 0;
					for(int k=0;k<m;k++){
//						System.out.println(topic[topic_i].charAt(k) +" : "+topic[topic_j].charAt(k)+"="+(topic[topic_i].charAt(k)|topic[topic_j].charAt(k)));
						if((topic[topic_i].charAt(k)|topic[topic_j].charAt(k)) == '1'){
							topics++;
							if(maxTopics < topics){
								maxTopics = topics;
							}
						}
					}
				}
			}
		}
		for(int topic_i=0;topic_i < n;topic_i++){
			for(int topic_j=topic_i+1;topic_j<n;topic_j++){
				if(topic_i != topic_j){
//					System.out.println(topic[topic_i]+ " and "+topic[topic_j]+ " : " );
					topics = 0;
					for(int k=0;k<m;k++){
//						System.out.println(topic[topic_i].charAt(k) +" : "+topic[topic_j].charAt(k)+"="+(topic[topic_i].charAt(k)|topic[topic_j].charAt(k)));
						if((topic[topic_i].charAt(k)|topic[topic_j].charAt(k)) == '1'){
							topics++;
							if(topics == maxTopics){
								nb++;
							}
						}
					}
				}
			}
		}
		
		
		System.out.println(maxTopics+"\n"+nb);
		in.close();

	}
	
}
