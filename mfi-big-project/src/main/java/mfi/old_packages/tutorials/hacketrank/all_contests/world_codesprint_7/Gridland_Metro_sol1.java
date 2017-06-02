package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
                -----------------------------------------------
  ========                                                         ==========
  
  
  
 
  	20 20  9			 	
	 1  2  3
	 1 17 18
	 1  4  5
	 1 14 15
	 1	5  6
	 1 15 16
	 1  8 12
	 1  3  6
	 1 14 18
	
  
 * 
Sample Input

4 4 3
2 2 3
3 1 4
4 4 4

Sample Output

9 
 * */	

public class Gridland_Metro_sol1 {
	

		static double eps=(double)1e-6;  // 1/1000 000
		static int mod=(int)1e9+7; // 1 000 000 000 + 7 
		
		private static void printList(ArrayList lt){
			for(int i=0;i<lt.size();i++){
				Pair p = (Pair)lt.get(i);
				System.out.println(i+":["+p.row+","+p.x+","+p.y+"]");
			}
			System.out.println();
		}
		
		public static void main(String args[]){
			InputReader in = new InputReader(System.in);
			OutputStream outputStream = System.out;
			PrintWriter out = new PrintWriter(outputStream);
			//----------My Code----------
			long n=in.nextInt();
			long m=in.nextInt();
			int k=in.nextInt();
			ArrayList<Pair> arr=new ArrayList<>();
			for(int i=0;i<k;i++){
				int r=in.nextInt();
				int c1=in.nextInt();
				int c2=in.nextInt();
				arr.add(new Pair(c1,c2,r));
			}
			printList(arr);
			Collections.sort(arr);
			printList(arr);
			
			long add=0;
			int cur=-1;
			long start=-1,end=-1;
			for(Pair p:arr){
				System.out.println(":[cur,start,end]:["+cur+","+start+","+end+"]\t p(row,x,y):p("+p.row+","+p.x+","+p.y+")");
				if(p.row==cur){
					if(p.y<end){
						continue;
					}
					else if(p.x>end){
						add+=end-start+1;
						start=p.x;
						end=p.y;
					}
					else{
						end=Math.max(end, p.y);
					}
				}
				else{
					if(end!=-1)
						add+=end-start+1;
					cur=p.row;
					start=p.x;
					end=p.y;
				}
				//System.out.println(add+" "+p.x+" "+p.y+" "+p.row);
			}
			if(end!=-1)
				add+=end-start+1;
			System.out.println((n*m)-add);
			out.close();
			//---------------The End------------------
	 
		}
		static class Pair implements Comparable<Pair>{
			long x;
			long y;
			int row;
			Pair(long xx,long yy,int r){
				x=xx;
				y=yy;
				row=r;
			}
			@Override
			public int compareTo(Pair o) {
				if(Long.compare(this.row, o.row)!=0){
					return Long.compare(this.row, o.row);
				}
				else{
					if(Long.compare(this.x, o.x)!=0)
						return Long.compare(this.x, o.x);
					else
						return Long.compare(this.y, o.y);
				}
			}
		}
		public static void debug(Object... o) {
			System.out.println(Arrays.deepToString(o));
		}
		static class InputReader {
			public BufferedReader reader;
			public StringTokenizer tokenizer;
	 
			public InputReader(InputStream inputstream) {
				reader = new BufferedReader(new InputStreamReader(inputstream));
				tokenizer = null;
			}
	 
			public String nextLine(){
				String fullLine=null;
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					try {
						fullLine=reader.readLine();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
					return fullLine;
				}
				return fullLine;
			}
			public String next() {
				while (tokenizer == null || !tokenizer.hasMoreTokens()) {
					try {
						tokenizer = new StringTokenizer(reader.readLine());
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
				return tokenizer.nextToken();
			}
			public long nextLong() {
				return Long.parseLong(next());
			}
			public int nextInt() {
				return Integer.parseInt(next());
			}
		}
	}  

