package mfi.tech.java.array.AlgorithmicCrush;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

import mfi.old_packages.toBeReviewedPkg.mfi.util.fileUtil.FileUtil;

public class Solution {
	public static void main(String[] args) {
		long A = System.currentTimeMillis();
		BufferedReader reader = readTestCase();
		Scanner scan = new Scanner(reader);
       // Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        
        /* Save interval endpoint's "k" values in array */
        long [] array = new long[N + 1];
        while (M-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int k = scan.nextInt();
            array[a-1] += k;
            array[b]   -= k;
        }
        scan.close();
        
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
}