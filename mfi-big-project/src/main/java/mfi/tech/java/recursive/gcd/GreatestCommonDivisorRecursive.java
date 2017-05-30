package mfi.tech.java.recursive.gcd;

public class GreatestCommonDivisorRecursive {

	/*
	 * gcd(4,0) = x
	 * gcd(4,1) = gcd(1,4%1) = gcd(1,0) = 1
	 * gcd(4,2) = gcd(2,4%2) = gcd(2,0) = 2
	 * gcd(5,2) = gcd(2,5%2) = gcd(2,1) = gcd(1,2%1) = gcd(1,0) = 1
	 * gcd(2,5) = gcd(5,2%5) = gcd(5,2) = gcd(2, 5%2) = gcd(2,1) = ... = 1
	 *  
	 *  (4,0) = (0,1,2,4) ,All number = 4
	 *  (4,1) = (0,1,2,4) ,(1) = 1
	 *  (4,2) = (0,1,2,4) ,(1,2) = 2
	 *  (8,6) = (1,2,4)   ,(1,2,3) = 2
	 * */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GreatestCommonDivisorRecursive obj = new GreatestCommonDivisorRecursive();
		
		obj.doTestGetGreatestCommonDivisorRecursive(0,0);
		obj.doTestGetGreatestCommonDivisorRecursive(0,1);
		obj.doTestGetGreatestCommonDivisorRecursive(5,0);
		obj.doTestGetGreatestCommonDivisorRecursive(10,1);
		obj.doTestGetGreatestCommonDivisorRecursive(4,2);
		obj.doTestGetGreatestCommonDivisorRecursive(2,5);
		obj.doTestGetGreatestCommonDivisorRecursive(5,2);
		obj.doTestGetGreatestCommonDivisorRecursive(10,10);
		obj.doTestGetGreatestCommonDivisorRecursive(8,6);
		
	}
	public void doTestGetGreatestCommonDivisorRecursive(int x, int y){
		System.out.println("Greatest Common Divisor("+x+","+y+") = "+getGreatestCommonDivisorRecursive(x,y)+"\t"+gcd(x,y));
	}

	public int getGreatestCommonDivisorRecursive(int x, int y){
		if(Math.min(x, y) == 0){
			return Math.max(x, y);
		}else{
			return getGreatestCommonDivisorRecursive(y, x%y);
		}
	}
	
	public static double gcd(int x, int y){
		if(y == 0)
			return x;
		else 
			return gcd(y,x%y); 
	}
}
