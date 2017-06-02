package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_9;

public class PerfectChessOneQueenOneObstacle {

	final static String empty_cell = ".";
	final static String queen_cell = "Q";
	final static String queen_kill_cell = "0";
	final static String obstacle_cell = "X";
	final static String no_queen_kill_cell = "-";
	static String cell = "";
	static int c = 0;
	public static void main(String[] args) {
		
		int n = 10;
		int k = 0;
		int rQueen = 4;
		int cQueen = 5;
		int rObstacle = 6;
		int cObstacle = 7;
		for(int r=n;r>=1;r--){
			System.out.println("\n");
			for(int c=1;c<=n;c++){
				if(r == 4 && c == 1){
					System.out.print("");
				}
				
				if(r == rQueen && c == cQueen){
					cell = queen_cell;
					printP(r,c,cell);
				}else if( (r == rQueen && c != cQueen)
						||(r != rQueen && c == cQueen)
						||(Math.abs(r-rQueen) == Math.abs(c-cQueen))
						/*||(i-rQueen == j-cQueen)*/){
					cell = queen_kill_cell;
					if(r == rObstacle && c == cObstacle){
						cell = obstacle_cell;
					}
					if((r == rObstacle && rObstacle == rQueen && ( (c < cObstacle && cObstacle < cQueen)
																 ||(c > cObstacle && cObstacle > cQueen)))
					 ||(c == cObstacle && cObstacle == cQueen && ( (r < rObstacle && rObstacle < rQueen)
								                                 ||(r > rObstacle && rObstacle > rQueen)))
					 ||((Math.abs(r-rQueen) == Math.abs(c-cQueen))&&((Math.abs(r-rObstacle) == Math.abs(c-cObstacle)))
							 								  && ( (r < rObstacle && rObstacle < rQueen)
                             									 ||(r > rObstacle && rObstacle > rQueen)))
					  ){
						cell = no_queen_kill_cell;
					}
					printP(r,c,cell);
				}else{
					cell = empty_cell;
					if(r == rObstacle && c == cObstacle){
						cell = obstacle_cell;
					}
					printP(r,c,cell);
				}
//				printP(i,j,square_piece);
			}
		}
		System.out.print("\n number of cell that Queen can kill = "+c);
	}
	private static void printP(int i, int j, String cell){
		String xx = "["+i+","+j+"]:";
		xx = "";
		System.out.print(xx+cell+"\t");
		if(cell == queen_kill_cell){
            c++;
        }
	}
}
