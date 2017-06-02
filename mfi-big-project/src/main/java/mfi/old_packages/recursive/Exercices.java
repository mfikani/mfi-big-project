package mfi.old_packages.recursive;

public class Exercices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		
		//1- what mystery give ? 
		for(int i=1;i<10;i++){
			System.out.println("4 * "+i+" = "+mystery(4,i));
		}
		System.out.println("---------------------------------------");
		//
		for(int i=1;i<10;i++){
			System.out.println("sum("+i+") = "+sum(i));
		}
	}

	public static int sum(int n){
		if(n == 1)
			return 1;
		else
			return n + sum(n -1);
	}
	public static int mystery( int a, int b ){
		if ( b == 1 )
			return a;
		else
			return a + mystery( a, b - 1 );
	}  
}
