package mfi.old_packages.recursive;

public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * power(2,3) = 2 * 2 * 2
		 * power(2,2) = 2 * 2
		 * power(2,1) = 2
		 * power(2,0) = 1
		 *  
		 * */
		int x = power(4,2);
		System.out.println(x);
	}
	public static int power(int base, int exponent){
		if(exponent == 0)
			return 1;
		else{
			System.out.println(base+" * power("+base+", "+( exponent - 1)+")");
			return (base * power(base, exponent - 1));
		}
	}

}
