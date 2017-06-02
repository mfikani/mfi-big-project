package mfi.old_packages.recursive;

public class GreatestCommonDivisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* gcd(4,0) = x
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
		System.out.println("gcd(21,14): "+gcd(21,14));
	}
	public static double gcd(int x, int y){
		if(y == 0)
			return x;
		else 
			return gcd(y,x%y); 
	}
}
