package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gridland_Metro {

/*
Sample Input

4 4 3
2 2 3
3 1 4
4 4 4

Sample Output

9 
 * */	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		short k = sc.nextShort();
		int r=0,c1=0,c2=0;
		List train_tracks = new ArrayList();
		int count = 0;
		List occupiedRows = new ArrayList();
		List notEmptyRows = new ArrayList();
		for(int i=0;i<k;i++){
			r = sc.nextInt();
			c1 = sc.nextInt();
			c2 = sc.nextInt();
			if((c2-c1+1) < m ){
				Train_track t = new Train_track(r,c1,c2);
				train_tracks.add(t);
			}else{
				occupiedRows.add(r);
			}
			notEmptyRows.add(r);
			
		}
		
		for(int i=1;i<=n;i++){
			if(notEmptyRows.contains(i)){
				if(!occupiedRows.contains(i)){
					for(int j=1;j<=m;j++){
						System.out.println(i+","+j+" : "+isOccupied(train_tracks,i,j,n));
						if(!isOccupied(train_tracks,i,j,n)){
							count++;
						}
					}
				}
			}else{
				count = count+m;
			}
		}
		System.out.println(count);
		sc.close();
	}
	private static boolean isOccupied(List lst, int i, int j,int row){
		boolean res = false;
		Train_track tt;
		for(int k=0;k<lst.size();k++){
			tt = (Train_track)lst.get(k);
			//System.out.println(i+","+j);
			//System.out.println("row["+row+"]  K:"+k+"    ("+tt.r+","+tt.c1+","+tt.c2+")");			
			if(i == tt.r){
				//System.out.println("(i,j):"+"("+tt.c1+","+tt.c2+")");
				if(tt.c1 <= j && j <= tt.c2){
					res = true;
					break;
				}
			}
		}
		return res;
	}
	
	static class Train_track{
		int r;
		int c1; 
		int c2;
		public Train_track(int r, int c1,int c2){
			this.r = r;
			this.c1=c1;
			this.c2=c2;
		}
	}

}
