package mfi.old_packages.tutorials.hacketrank.dashboard.algorithms.strings.mars_exploration;

import java.util.Scanner;
/*
 url : https://www.hackerrank.com/challenges/mars-exploration
 
  Sample Input 0

SOSSPSSQSSOR
Sample Output 0

3
Sample Input 1

SOSSOT
Sample Output 1

1

Sample Input 
QQQ
Sample Output
3

input : SOSOSOSOSDSDSKWOSDOSDOASDOASDFAFJDFDOSOSOWNSOSOSNDSKDDOSOSOSJDSDSOOSOSDSDOSASSOASDSAOSOSODSDSOASDWS
output : 67
 * */
public class MarsExploration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in = new Scanner(System.in);
	     String S = in.next();
	     int nb = 0;
	     for(int i=0;i<S.length();i=i+3){
	    	 if(S.charAt(i)!='S'){
	    		 nb++;
	    	 }
	    	 if(S.charAt(i+1)!='O'){
	    		 nb++;
	    	 }
	    	 if(S.charAt(i+2)!='S'){
	    		 nb++;
	    	 }
	     }
	     System.out.println(nb);
	    
	     in.close();

	}

}
