package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day10_BinaryNumbers;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 Sample Input 1

5
Sample Output 1

1
Sample Input 2

13
Sample Output 2

2
 */

/*
 5 = 0 x pow(2,0) + 0 x pow(2,1) + 0 x pow(2,2)  
 * */
public class BinaryNumbersSolution {
	public static void test(){
		//		Scanner in = new Scanner(System.in);
		//		int n = in.nextInt();
		int n = 6;
		int rem=0,s=0,t=0;


		while(n>0)
		{
			rem=n%2;
			n=n/2;
			if(rem==1)
			{   s++;
			if(s>=t)

				t=s;

			}
			else{

				s=0;
			}   
		}

		System.out.println(t);

	}


	public static void main(String[] args){ 
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		int r = 0; 
		String s = "";
		while(n>=2){
			r = n%2;
			s +=r;
			n = n/2;
			if(n < 2){
				s +=n;
			}
		}
		int count = 1;
		System.out.println(s);
//		for(int i=0;i<s.length();i++){
//			if(i < s.length()-1 && s.charAt(i) == '1' && s.charAt(i+1) == '1'){
//				count++;
//			}
//		}
		s = s.replaceAll("00", "0");
				
		String[] ar = s.split("0");
		int max = 0;
		for(int i=0;i<ar.length;i++){
			if(max < ar[i].length()){
				max = ar[i].length();
			}
		}
		System.out.println(max);
		
		
		in.close();
	}

}
