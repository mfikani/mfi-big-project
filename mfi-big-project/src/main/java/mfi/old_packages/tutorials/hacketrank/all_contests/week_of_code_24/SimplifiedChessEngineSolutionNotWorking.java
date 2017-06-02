package mfi.old_packages.tutorials.hacketrank.all_contests.week_of_code_24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/*
 * 
 1
1 1 1
Q B 1
Q A 4 
  
 Sample Input



1
2 1 1
N B 2
Q B 1
Q A 4
Sample Output

YES 
 * */
public class SimplifiedChessEngineSolutionNotWorking {
	
	static int possibleMoveX = 0 , possibleMoveY = 0;
	static int board = 4;
	static final String WHITE = "white";
	static final String BLACK = "black";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String temp = "";
		List whiteTroops = new ArrayList();
		List blackTroops = new ArrayList();
		Position p = null;
		Troop t = null;
		int m=0;
		//HashMap troopHM = new HashMap();
		int g = in.nextInt();
		for(int i=0;i<g;i++){
			int w = in.nextInt();
			int b = in.nextInt();
			m = in.nextInt();

			for(int i1=0;i1<w;i1++){
				String c = in.next();
				temp = in.next();
				int x = (temp.equals("A"))?1:(temp.equals("B"))?2:(temp.equals("C"))?3:(temp.equals("D"))?4:4;
				int y = in.nextInt();
				t = new Troop(new Position(x,y),c,WHITE,null);
				whiteTroops.add(t);
			}
			for(int i1=0;i1<b;i1++){
				String c = in.next();
				temp = in.next();
				int x = (temp.equals("A"))?1:(temp.equals("B"))?2:(temp.equals("C"))?3:(temp.equals("D"))?4:4;
				int y = in.nextInt();
				t = new Troop(new Position(x,y),c,BLACK,null);
				blackTroops.add(t);
			}
		}
		int blackQueenX = 0,blackQueenY = 0;
		List blackTroopsPositions = new ArrayList();
		for(int i=0;i<blackTroops.size();i++){
			Troop blackTroop = (Troop)blackTroops.get(i);
			if(blackTroop.type.equals("Q")){
				blackQueenX = blackTroop.p.x;
				blackQueenY = blackTroop.p.y;
			}else{
				blackTroopsPositions.add(blackTroop.p);
			}
		}
		int nbMove = 0;
		boolean killed = false;
		String movesStr = "";
		while(nbMove <= m && !killed){
			for(int j=0;!killed && j<whiteTroops.size();j++){
				Troop whiteTroop = (Troop)whiteTroops.get(j);
				List possibleMovesLt = whiteTroop.getPossibleMoves(whiteTroop.type);
				if(possibleMovesLt != null && possibleMovesLt.size() > 0){
					for(int z = 0;z<possibleMovesLt.size();z++){
						Position whiteMove = (Position)possibleMovesLt.get(z); 
						movesStr += "\nMove"+(nbMove+1)+":"+(whiteTroop.color+"  "+whiteTroop.type+" CAN move from ("+whiteTroop.p.x+","+whiteTroop.p.y+") TO ("+whiteMove.x+","+whiteMove.y+")");
						if(containPosition(possibleMovesLt,new Position(blackQueenX,blackQueenY))){
							movesStr +="\n CHECKMATE : "+(whiteTroop.color+"  "+whiteTroop.type+" DO move from ("+whiteTroop.p.x+","+whiteTroop.p.y+") TO ("+blackQueenX+","+blackQueenY+")");
							killed = true;
							break;
						}else{
							if(!blackTroopsPositions.contains(whiteMove)){
								movesStr +="\n"+(whiteTroop.color+"  "+whiteTroop.type+" DO move from ("+whiteTroop.p.x+","+whiteTroop.p.y+") TO ("+whiteMove.x+","+whiteMove.y+")");
								whiteTroop.doMove(whiteMove);
								nbMove++;
							}
						}
					}
				}			
			}
		}
		System.out.println(movesStr);
		System.out.println((killed)?"YES":"NO");

		in.close();
	}
	private static boolean containPosition(List positions, Position p){
		boolean res = false;
		if(positions != null){
			for(int i=0;i<positions.size();i++){
				Position temp = (Position)positions.get(i);
				if(temp.x == p.x && temp.y == p.y){
					res = true;
					break;
				}
			}		
		}
		return res;
	}
	static class Troop {
		Position p;
		String type;
		String color;
		Position newP;
		Troop(Position p1, String type1, String color1, Position newP1){
			this.p = p1;
			this.type = type1;
			this.color = color1;
			this.newP = newP1;
		}
		public void doMove(Position newP){
			p = newP;
		}
		private boolean inBoard(int xx){
			boolean res = false;
			if(1 <= xx && xx <=4){
				res = true;
			}
			return res;
		}
		private void printMove(String type,List lt){
			String s = type+"("+p.x+","+p.y+") can move to : ";
			if(lt != null && lt.size()>0){
				for(int i=0;i<lt.size();i++){
					Position pp = (Position)lt.get(i);
					s +="("+pp.x+","+pp.y+")";
				}
			}
			System.out.println(s);
		}
	
		public List getPossibleMoves (String type1){
			List possibleMoves = new ArrayList();
			Position pp = null;
			if(type1.equals("Q")){
				for(possibleMoveX=1;possibleMoveX<board;possibleMoveX++){
					if(inBoard(p.x+possibleMoveX)){
						pp = new Position(p.x+possibleMoveX,p.y);
						possibleMoves.add(pp);
					}
					if(inBoard(p.x-possibleMoveX)){
						pp = new Position(p.x-possibleMoveX,p.y);
						possibleMoves.add(pp);
					}
					if(inBoard(p.y+possibleMoveX)){
						pp = new Position(p.x,p.y+possibleMoveX);
						possibleMoves.add(pp);
					}
					if(inBoard(p.y-possibleMoveX)){
						pp = new Position(p.x,p.y-possibleMoveX);
						possibleMoves.add(pp);
					}
				}
				printMove(type1,possibleMoves);				
			}else if(type1.equals("N")){
				//	(p.x+1,p.y+3);(p.x+1,p.y-3);(p.x-1,p.y+3);(p.x-1,p.y-3)
				//	(p.x+3,p.y+1);(p.x+3,p.y-1);(p.x-3,p.y+1);(p.x-3,p.y-1)
				possibleMoveX = 1;possibleMoveY = 2;
				if(inBoard(p.x+possibleMoveX) && inBoard(p.y+possibleMoveY)){
					pp = new Position(p.x+possibleMoveX,p.y+possibleMoveY);
					possibleMoves.add(pp);
				}
				if(inBoard(p.x+possibleMoveX) && inBoard(p.y-possibleMoveY)){
					pp = new Position(p.x+possibleMoveX,p.y-possibleMoveY);
					possibleMoves.add(pp);
				}
				if(inBoard(p.x-possibleMoveX) && inBoard(p.y+possibleMoveY)){
					pp = new Position(p.x-possibleMoveX,p.y+possibleMoveY);
					possibleMoves.add(pp);
				}
				if(inBoard(p.x-possibleMoveX) && inBoard(p.y-possibleMoveY)){
					pp = new Position(p.x-possibleMoveX,p.y-possibleMoveY);
					possibleMoves.add(pp);
				}
				possibleMoveX = 2;possibleMoveY = 1;
				if(inBoard(p.x+possibleMoveX) && inBoard(p.y+possibleMoveY)){
					pp = new Position(p.x+possibleMoveX,p.y+possibleMoveY);
					possibleMoves.add(pp);
				}
				if(inBoard(p.x+possibleMoveX) && inBoard(p.y-possibleMoveY)){
					pp = new Position(p.x+possibleMoveX,p.y-possibleMoveY);
					possibleMoves.add(pp);
				}
				if(inBoard(p.x-possibleMoveX) && inBoard(p.y+possibleMoveY)){
					pp = new Position(p.x-possibleMoveX,p.y+possibleMoveY);
					possibleMoves.add(pp);
				}
				if(inBoard(p.x-possibleMoveX) && inBoard(p.y-possibleMoveY)){
					pp = new Position(p.x-possibleMoveX,p.y-possibleMoveY);
					possibleMoves.add(pp);
				}
				printMove(type1, possibleMoves);				
			}else if(type1.equals("B")){
				for(possibleMoveX =1;possibleMoveX <=4;possibleMoveX ++){
					for(possibleMoveY = 1;possibleMoveY <=4;possibleMoveY++ ){
						if(possibleMoveX == possibleMoveY){
							if(inBoard(p.x+possibleMoveX) && inBoard(p.y+possibleMoveY)){
								pp = new Position(p.x+possibleMoveX,p.y+possibleMoveY);
								possibleMoves.add(pp);
							}
							if(inBoard(p.x+possibleMoveX) && inBoard(p.y-possibleMoveY)){
								pp = new Position(p.x+possibleMoveX,p.y-possibleMoveY);
								possibleMoves.add(pp);
							}
							if(inBoard(p.x-possibleMoveX) && inBoard(p.y+possibleMoveY)){
								pp = new Position(p.x-possibleMoveX,p.y+possibleMoveY);
								possibleMoves.add(pp);
							}
							if(inBoard(p.x-possibleMoveX) && inBoard(p.y-possibleMoveY)){
								pp = new Position(p.x+possibleMoveX,p.y+possibleMoveY);
								possibleMoves.add(pp);
							}
						}
					}
				}
				printMove(type1, possibleMoves);				
			}else if(type1.equals("R")){
				if(color.equals("white") && p.y+1 < 5){
					pp = pp = new Position(p.x,p.y+1);
				}else if(color.equals("black") && p.y-1 < 5){
					pp = pp = new Position(p.x,p.y-1);
				}
				possibleMoves.add(pp);
				printMove(type1, possibleMoves);
			}
			return possibleMoves;
		}


	}
	static class Position{
		int x;
		int y;
		Position(int x1, int y1){
			this.x = x1;
			this.y = y1;
		}
	}
}
