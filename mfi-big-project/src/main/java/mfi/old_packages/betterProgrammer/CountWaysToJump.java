package mfi.old_packages.betterProgrammer;

import java.util.ArrayList;
import java.util.List;

public class CountWaysToJump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countWaysToJump(4);
	}
	public static int countWaysToJump(int N) {
        /*
          A set of stairs has N steps.
          You can jump either 1 or 2 steps at a time.
          For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
          1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
          Please implement this method to
          return the count of the different ways to reach the end of the stairs with N steps.
          
          2-2
          2-1-1
          1-2-1
          1-1-2
          1-1-1-1
         */
		
		int s = 0;
		int o = 0;
		int j1 = 1, j2 = 2;
		int ways = 0;
		String road = "";
		List roads = new ArrayList();
		boolean firstStepJ2 = true; 
		boolean secondStepJ2 = false;
		while(s != N){
			System.out.println(roads);
			if((s + j2)< N && (firstStepJ2 == true || secondStepJ2 == true) && !roads.contains(road+"-"+j2+ "-"+j1)){
				s = s + j2;
				road = (road.length() == 0)?j2+"":road + "-"+j2;
			}else if(s + j2 == N && !roads.contains(road + "-"+j2) && (firstStepJ2 == true || secondStepJ2 == true)){
				road = road + "-"+j2;
				roads.add(road);
				road = "";
				s = 0;
			}else if((s + j1) < N && !roads.contains(road+ "-"+j1)){
				s = s + j1;
				road = (road.length() == 0)?j1+"":road + "-"+j1;
				if(s == j1){
					secondStepJ2 = true;
				}
			}else if( s + j1 == N && !roads.contains(road+ "-"+j1)){
				road = road + "-"+j1;
				roads.add(road);
				road = "";
				s = 0;
				firstStepJ2 = false;
				secondStepJ2 = false;
			}
		}	
		
		return ways;
    }

}
