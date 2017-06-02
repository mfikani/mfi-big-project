package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_9;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class QueensAttack2_2 {


	public static void main(String[] args) {
		String empty_cell = ".";
		String queen_cell = "Q";
		String queen_kill_cell = "0";
		String obstacle_cell = "X";
		String no_queen_kill_cell = "-";
		String cell = "";
		int max_left = 0;
		int min_right = 0;
		int min_top = 0;
		int max_buttom = 0;
		Pairs pp;
		int rObstacle = 0;
		int cObstacle = 0;
		
		int cc = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQueen = in.nextInt();
		int cQueen = in.nextInt();

		if(k == 0){
			for(int r=n;r>=1;r--){
				for(int c=1;c<=n;c++){
					 if(((r == rQueen && c != cQueen)
							||(r != rQueen && c == cQueen)
							||(!(r == rQueen && c == cQueen)&&(Math.abs(r-rQueen) == Math.abs(c-cQueen) )))){
						cell = queen_kill_cell;
						cc++;
					}
				}
			}
		}else{
			ArrayList lt = new ArrayList();
			for(int a0 = 0; a0 < k; a0++){
				int rObstacle1 = in.nextInt();
				int cObstacle1 = in.nextInt();
				Pairs p = new Pairs(rObstacle1,cObstacle1);
				if(!lt.contains(p)){
					lt.add(p);
				}
			}
			ArrayList blocked_cells = new ArrayList();
			for(int r=n;r>=1;r--){
				for(int c=1;c<=n;c++){
					if(r == rQueen && c == cQueen){
						cell = queen_cell;						
					}else if( (r == rQueen && c != cQueen)
							||(r != rQueen && c == cQueen)
							||(!(r == rQueen && c == cQueen) && (Math.abs(r-rQueen) == Math.abs(c-cQueen)))){
						cell = queen_kill_cell;
						
						Pairs tempPair = (Pairs)lt.get(0);
						max_left = tempPair.x;
						min_right = tempPair.x;
						min_top = tempPair.y;
						max_buttom = tempPair.y;
												
						for(int ii=0;ii<lt.size();ii++){
							pp = (Pairs)lt.get(ii);
							int rObstacle1 = pp.x;
							int cObstacle1 = pp.y;
							 
							if(r == rObstacle1 && c == cObstacle1){
								cell = obstacle_cell;
								break;
							}else if(r == rObstacle1 && rObstacle1 == rQueen && ( (c < cObstacle1 && cObstacle1 < cQueen))){
								if(cObstacle1 > max_left){
									max_left = cObstacle1;
								}
							}else if(r == rObstacle1 && rObstacle1 == rQueen && ( (c > cObstacle1 && cObstacle1 > cQueen))){
								
							}
								
								
								if((r == rObstacle1 && rObstacle1 == rQueen && ( (c < cObstacle1 && cObstacle1 < cQueen)
									||(c > cObstacle1 && cObstacle1 > cQueen)))
									||(c == cObstacle1 && cObstacle1 == cQueen && ( (r < rObstacle1 && rObstacle1 < rQueen)
											||(r > rObstacle1 && rObstacle1 > rQueen)))
									||((Math.abs(r-rQueen) == Math.abs(c-cQueen))&&((Math.abs(r-rObstacle1) == Math.abs(c-cObstacle1)))
											&& ( (r < rObstacle1 && rObstacle1 < rQueen)
													||(r > rObstacle1 && rObstacle1 > rQueen)))
									){
								cell = no_queen_kill_cell;  
								break;
							}
							else{
								cell = queen_kill_cell;
								if(ii == lt.size()-1){
									cc++;
								}								
							}
						}
					}
				}
			}
		}
		System.out.print(cc);
	}
}
class Pairs{
	int x;
	int y;
	Pairs(int x, int y){
		this.x = x;
		this.y = y;
	}
}
