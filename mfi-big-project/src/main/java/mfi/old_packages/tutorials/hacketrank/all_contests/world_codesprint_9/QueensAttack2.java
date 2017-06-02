package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_9;

import java.util.ArrayList;
import java.util.Scanner;

public class QueensAttack2 {

	final static String empty_cell = ".";
	final static String queen_cell = "Q";
	final static String queen_kill_cell = "0";
	final static String obstacle_cell = "X";
	final static String no_queen_kill_cell = "-";
	static String cell = "";

	public static void main(String[] args) {
		int cc = 0;
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQueen = in.nextInt();
		int cQueen = in.nextInt();

		if(k == 0){
			for(int r=n;r>=1;r--){
				System.out.println("\n");
				for(int c=1;c<=n;c++){
					if(r == rQueen && c == cQueen){
						cell = queen_cell;
						//cc++;
						printP(r,c,cell);
					}else if( (r == rQueen && c != cQueen)
							||(r != rQueen && c == cQueen)
							||(Math.abs(r-rQueen) == Math.abs(c-cQueen) )
							/*||(i-rQueen == j-cQueen)*/){
						cell = queen_kill_cell;
						cc++;
						printP(r,c,cell);
					}else{
						cell = empty_cell;
						printP(r,c,cell);
					}
				}
			}
		}else{
			ArrayList lt = new ArrayList();
			for(int a0 = 0; a0 < k; a0++){
				int rObstacle = in.nextInt();
				int cObstacle = in.nextInt();
				Pair p = new Pair(rObstacle,cObstacle);
				if(!lt.contains(p)){
					lt.add(p);
				}
			}
			//int n = 6;
			//int k = 0;
			//int rQueen = 4;
			//int cQueen = 3;
			//int rObstacle = 3;
			//int cObstacle = 4;
			for(int r=n;r>=1;r--){
				//System.out.println("\n");
				for(int c=1;c<=n;c++){

					if(r == rQueen && c == cQueen){
						cell = queen_cell;						
						printP(r,c,cell);
					}else if( (r == rQueen && c != cQueen)
							||(r != rQueen && c == cQueen)
							||(Math.abs(r-rQueen) == Math.abs(c-cQueen))
							/*||(i-rQueen == j-cQueen)*/){
						cell = queen_kill_cell;						
						for(int ii=0;ii<lt.size();ii++){
							Pair pp = (Pair)lt.get(ii);
							int rObstacle = pp.x;
							int cObstacle = pp.y;
							if(r == rObstacle && c == cObstacle){
								cell = obstacle_cell;
								break;
							}else if((r == rObstacle && rObstacle == rQueen && ( (c < cObstacle && cObstacle < cQueen)
									||(c > cObstacle && cObstacle > cQueen)))
									||(c == cObstacle && cObstacle == cQueen && ( (r < rObstacle && rObstacle < rQueen)
											||(r > rObstacle && rObstacle > rQueen)))
									||((Math.abs(r-rQueen) == Math.abs(c-cQueen))&&((Math.abs(r-rObstacle) == Math.abs(c-cObstacle)))
											&& ( (r < rObstacle && rObstacle < rQueen)
													||(r > rObstacle && rObstacle > rQueen)))
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

						printP(r,c,cell);
					}else{
						cell = empty_cell;
						for(int ii=0;ii<lt.size();ii++){
							Pair pp = (Pair)lt.get(ii);
							int rObstacle = pp.x;
							int cObstacle = pp.y;
							if(r == rObstacle && c == cObstacle){
								cell = obstacle_cell;
								break;								
							}
						}
						printP(r,c,cell);
					}
					//					printP(i,j,square_piece);
				}
			}
		}
		System.out.print(cc);
	}
	private static void printP(int i, int j,String cell){
		String xx = "["+i+","+j+"]:";
		//xx = "";
		//System.out.print(xx+cell+"\t");

	}
}
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
