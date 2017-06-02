package mfi.old_packages.tutorials.hacketrank.all_contests.week_of_code_24;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HappyLadyBugsSolution {

	private static int getNbOcc(String s, char c){
		int res = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == c){
				res++;
			}
		}
		return res;
	}
	
	 public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
	        int Q = in.nextInt();
List lt = new ArrayList();
	        for(int a0 = 0; a0 < Q; a0++){
	        	lt = new ArrayList();
	            int n = in.nextInt();
	            String b = in.next();
	            //System.out.println(">>>>>"+b);
	            boolean isOk = true;
	            int nbMove = 0;
	            
				for(int i = 0;i<b.length();i++){
					
		        	char c = b.charAt(i);
		        	//System.out.println("c["+c+"] : b["+b+"]\ngetNbOcc(b,c):"+getNbOcc(b,c)+"\ngetNbOcc(b,'_'):"+getNbOcc(b,'_'));
		        	if(isOk && (c >= 'A' && c <= 'Z')){
		        		if(i > 1 && c == b.charAt(i-1)){
		        			continue;
		        		}
		        		if(i < b.length()-1 && c == b.charAt(i+1)){
		        			continue;
		        		}
		        		
		        		if(getNbOcc(b,c) <= 1){
		        			isOk = false;
		        			
		        		}else{
		        			if(!lt.contains(c)){
		        				lt.add(c);
		        			}		        			
//		        			if(getNbOcc(b,'_') < (nbMove+1)){
//		        				isOk = false;
//		        			}
		        		}
		        	}
		        }
				if(lt.size() > 1 && getNbOcc(b,'_') < 1){
					isOk = false;
				}
//				if(getNbOcc(b,'_') < (lt.size()-1)){
//    				isOk = false;
//    			}
			//	System.out.println(b+" : "+(isOk?"YES":"NO"));
	        
                System.out.println((isOk?"YES":"NO"));
	        }
	        
	       
	    
    }
    
}
