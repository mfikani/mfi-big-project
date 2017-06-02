package mfi.old_packages.recursive.factorial;

public class RecursiveFactorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 
		 * !4 = 1 * 2 * 3 * 4;
		 * !3 = 1 * 2 * 3;
		 * !2 = 1 * 2;
		 * !1 = 1;
		 * */
		for(int i=0;i<5;i++){
//			System.out.println("!"+i+": "+Factorial(i));
		}
		for(int i=0;i<5;i++){
			//System.out.println("!"+i+": "+VisualFactorial(i,""));
			//VisualFactorial(i,"");
		}
		VisualFactorial(5,"");

	}
	public static long VisualFactorial(long n,String indent){
		long res = -1;
		if(n == 1 || n == 0){
			res = n;
			indent = ""+n;
		}else{
			//res = (n * VisualFactorial(n-1, (indent+"\t"))); 
			res = (n * VisualFactorial(n-1, indent));
			indent = n + " * "+ VisualFactorial(n-1, indent)+" = "+res;
		}
		System.out.println("-------------------------------");
		//System.out.println("n :" + n + ": ");
		System.out.println("!"+n+" = "+indent);
		return res;
	}
	public static long Factorial(long n){
		if(n == 1 || n == 0){
			return n;
		}else{
			return (n * Factorial(n-1));
		}
	}

}
