package mfi.old_packages.tutorials.hacketrank.tutorials.algorithms.implementation.modified_kaprekar_numbers;

import java.util.Scanner;

public class ModifiedKaprekarNumbersSolution {
/*
 https://www.hackerrank.com/challenges/kaprekar-numbers?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
 
 A modified Kaprekar number is a positive whole number  with  digits, such that when we split its square into two pieces - a right hand piece  with  digits and a left hand piece  that contains the remaining  or  digits, the sum of the pieces is equal to the original number (i.e.  +  = ).

Note: r may have leading zeros.

Here's an explanation from Wikipedia about the ORIGINAL Kaprekar Number (spot the difference!): In mathematics, a Kaprekar number for a given base is a non-negative integer, the representation of whose square in that base can be split into two parts that add up to the original number again. For instance, 45 is a Kaprekar number, because 45² = 2025 and 20+25 = 45.

The Task 
You are given the two positive integers  and , where  is lower than . Write a program to determine how many Kaprekar numbers are there in the range between  and  (both inclusive) and display them all.

Input Format

There will be two lines of input: , lowest value , highest value

Constraints: 

Output Format

Output each Kaprekar number in the given range, space-separated on a single line. If no Kaprekar numbers exist in the given range, print INVALID RANGE.

Sample Input

1
100
Sample Output

1 9 45 55 99

Explanation

1 9 45 55 99 are the Kaprekar Numbers in the given range.
  
  45² = 2025 and 20+25 = 45
  
  1² = 1 and 1+0 = 1
  9² =  81 and 8+1 = 9
  10² = 100 and 10+0
  55² = 3025 and 30+25 = 55
  99² = 9801 and 98+01 = 99
  
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int q = in.nextInt();
		int i = p;
		boolean found = false;
		while(i <= q){
			if(isKaprekarNumber(i)){
				System.out.print(i+" ");
                found = true;
			}
			i++;
		}
        if(!found){
            System.out.print("INVALID RANGE");
        }
		
		in.close();
	}
	public static boolean isKaprekarNumber(int x){
		boolean res = false;
		long sq = (long) Math.pow(x, 2);
		String s  = String.valueOf(sq);
		if( 1 * x == sq){
			res = true;
		}else{
			for(int i=1;i<s.length();i++){
				String x1 = s.substring(0,i);
				String x2 = s.substring(i,s.length());
				if(x == 99000){
					System.out.println("\n"+x+": ("+x1+","+x2+")="+(new Integer(x1)+new Integer(x2))+" "+s+" : "+((new Integer(x1)+(new Integer(x2))== x)));
				}
				if(new Integer(x2) == 0 || x2.length() < x1.length() || (x2.length()-x1.length()) > 1)continue;
				if((new Integer(x1)+new Integer(x2))== x){
					res = true;
					break;
				}
			}
		}
		
		return res;
	}

}
