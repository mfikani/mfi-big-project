package mfi.old_packages.method_with_multiple_arguments;

import java.util.Arrays;

public class TutorialMethodWithMultipleArgs {
	
	public static void main(String[] args){
		
		//1- function with 2 params
		System.out.println("Average of ["+5+","+12+"]= "+averageTwoNbr(5,12) );
		
		//2- function with an array as params
		int[] ar = {1,2,3,4,5,6,7};
		System.out.println("Average of the array "+Arrays.toString(ar)+" = "+averageOfArray(ar));
		
		//3- function with variant args as param, can be 2 args or 3 .... or n args
		System.out.println();
		System.out.println("Average of mutiple params [1,2.5,3,4] = "+averageMultiArgs(1,2.5,3,4));
		System.out.println("Average of mutiple params [1,2.5] = "+averageMultiArgs(1,2.5));

		//4- function with one or more args as param		
		System.out.println();
		System.out.println("Maximum of [10]: "+max(10));
		System.out.println("Maximum of [10, 1.2, 4, 5, 10.2, 10.09]: "+max(10, 1.2, 4, 5, 10.2, 10.09));
		
		//5- printf
		System.out.println();
		System.out.println("Printing with spaces: ");
		doPrintf();
		
		doPrintCalendarExample();
	}
	
	private static double averageMultiArgs(double  ... values){
		double sum = 0;
		for(double v : values) sum +=v;
		return (values.length == 0)? 0 : sum/values.length;
		
	}
	private static double max(double first, double ... rest){
		double result = first;
		for(double v : rest) result = Math.max(v, result);
		return result;
	}
	
	private static int averageTwoNbr(int x, int y){
		return (x + y)/2;
	}
	
	private static int averageOfArray(int[] ar){
		int sum = 0;
		for(int i=0;i<ar.length;i++){
			sum += ar[i];
		}
		return sum/ar.length;
	}
	private  static void doPrintf(){
		System.out.printf("%1d" , 10);
		System.out.println();
		System.out.printf("%2d" , 10);
		System.out.println();
		System.out.printf("%3d" , 10);
		System.out.println();
		System.out.printf("%30d" , 10);
		System.out.println();
		System.out.printf("%3d %2s" , 10, 5);
		System.out.println();
		System.out.printf("[%5s]   [%s]" , "aa","5 digits:3before+aa");		
	}
	
	private static void doPrintCalendarExample(){
		System.out.println("\n\nCalendar Example\n");
		System.out.printf("%5d %5d %5d\n%5d %5d %5d\n%5d %5d %5d",1,2,3,4,5,6,7,8,9);
	}
}
