package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.graph_theroy.going_to_the_office;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 Sample Input

6 9  
0 1 1  
1 2 1  
2 3 1  
3 4 1  
4 5 1  
2 4 5  
3 5 8  
1 3 3  
0 2 4  
0 5  
9  
0 1  
1 2  
2 3  
3 4  
4 5  
2 4  
3 5  
1 3  
0 2

 Sample Output

7  
6  
6  
8  
11  
5  
5  
5  
5

 * */
public class Solution {
	public static void main(String[] args){
		int N = 0,M = 0,S = 0, D = 0, Q = 0;
		ArrayList list = null, listBlocked = null;
		
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		printInfo(N,M,list, S, D, Q, listBlocked);
		
		list = new ArrayList();
		int ss = 0;
		int dd = 0;
		int distance = 0;
		for(int i = 0; i< M; i++){
			ss = scan.nextInt();
			dd = scan.nextInt();
			distance = scan.nextInt();
			DistanceBetweenTwoCities obj = new DistanceBetweenTwoCities(ss,dd,distance);
			list.add(obj);
		}
		
		printInfo(N,M,list, S, D, Q, listBlocked);
		
		S = scan.nextInt();
		D = scan.nextInt();
		
		Q = scan.nextInt();
		printInfo(N,M,list, S, D, Q, listBlocked);
		listBlocked = new ArrayList();
		for(int i = 0; i< Q; i++){
			ss = scan.nextInt();
			dd = scan.nextInt();
			RoadBlocked obj = new RoadBlocked(ss,dd);
			listBlocked.add(obj);
		}
		scan.close();
		
		printInfo(N,M,list, S, D, Q, listBlocked);
		
		
		
	}
	private static void printInfo(int N, int M, List lt, int S, int D, int Q, List listBlocked){
		System.out.println("Number of cities: "+N+"\nNumber of roads: "+M);
		
		System.out.println("Printing distance between cities : ");
		if(lt != null){
			for(int i=0;i<lt.size();i++){
				DistanceBetweenTwoCities obj = (DistanceBetweenTwoCities)lt.get(i);
				System.out.println(obj.getCitySource()+" "+obj.getCityDestination()+" "+obj.getDistance());
			}
		}
		System.out.println("Source city: "+S+"\nDestination city: "+D);
		System.out.println("Number of Queries: "+Q);
		if(listBlocked != null){
			for(int i=0;i<listBlocked.size();i++){
				RoadBlocked obj = (RoadBlocked)listBlocked.get(i);
				System.out.println(obj.getCitySource()+" "+obj.getCityDestination());
			}
		}
	}
	
}
class DistanceBetweenTwoCities{
	private int citySource;
	private int cityDestination;
	private int distance;
	
	public DistanceBetweenTwoCities(int s, int d, int dist){
		this.citySource = s;
		this.cityDestination = d;
		this.distance = dist;
	}
	public int getCitySource(){
		return this.citySource;
	}
	public int getCityDestination(){
		return this.cityDestination;
	}
	public int getDistance(){
		return this.distance;
	}
}
class RoadBlocked{
	private int citySource;
	private int cityDestination;
	public RoadBlocked(int s, int d){
		this.citySource = s;
		this.cityDestination = d;
	}
	public int getCitySource(){
		return this.citySource;
	}
	public int getCityDestination(){
		return this.cityDestination;
	}
}