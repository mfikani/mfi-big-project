package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_9;

import java.util.Scanner;
/*
4
73
67
38
33
 
 * */
public class GradingStudent {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int grade = in.nextInt();
            // your code goes here
            if((grade+3)>40){
            	int i=0;
            	int nextM = grade+i;
            	while((grade+i) %5 !=0){
            		i++;
            	}
            	nextM = grade+i;
            	if(nextM - grade < 3){
            		grade = nextM;
            	}
            }
            System.out.println(grade);
        }
        in.close();
    }
}
