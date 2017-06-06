package mfi.tech.java.array.AlgorithmicCrush;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

import mfi.old_packages.toBeReviewedPkg.mfi.util.fileUtil.FileUtil;
/*

Sample Input
5 3
1 2 100
2 5 100
3 4 100



Sample output
200
  
explanation :   
Let's view the array as a list of histograms. Each position in the array has a histogram with a certain variable heigth. It would be cumbersome to keep track of the heigth of every single histogram. Instead, you could just keep track of how much the height of a given histogram differs from the one preceding it (in a continuous setting, this would mean to keep track of the derivative of a function, not the function itself).
Here, we know there is an increment of k for the height of the histogram in position a (a positive slope of k from a-1 to a), but then the height remains constant at positions a+1, a+2,...,b. Then again, we know that position b was the last position where histograms were incremented by k, so there is a decrement of -k at position b+1 (negative slope of -k from b to b+1).
Hope this helps.
 * */
public class AlgorithmicCrushSolutionOpt {
	public static void main(String[] args) {
		long A = System.currentTimeMillis();
		BufferedReader reader = readTestCase();
		
		
		//Scanner scan = new Scanner(reader);
        Scanner scan = new Scanner(System.in);
		
		
        int N = scan.nextInt();
        int M = scan.nextInt();
        
        /* Save interval endpoint's "k" values in array */
        long [] array = new long[N + 1];
        printArr(array);
        while (M-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int k = scan.nextInt();
            array[a-1] += k;
            array[b]   -= k;
            System.out.print(a+" "+b+" "+k+" : ");printArr(array);
        }
        scan.close();
        printArr(array);
        
        /* Find max value */
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }
        
        System.out.println(max);
        System.out.println("Time : "+(System.currentTimeMillis() - A));
    }
	public static BufferedReader readTestCase(){
		File file = new File("D:\\WORK\\mfi-big-project\\mfi-big-project\\src\\main\\java\\mfi\\tech\\java\\array\\AlgorithmicCrush\\test-case\\textcase1.txt");
		if(file.exists()){
			System.out.println("File Exists");
		}else{
			System.out.println("Wrong path");
		}
		
		System.out.println("Reading the file");
		//System.out.println(file.getAbsolutePath()+":\n"+FileUtil.readFileData(file));
		return FileUtil.readFileDataTest(file);
	}
	public static void printArr(long[] arr){
		for(long l : arr){
			System.out.print(l+"\t ");
		}
		System.out.println();
	}
}