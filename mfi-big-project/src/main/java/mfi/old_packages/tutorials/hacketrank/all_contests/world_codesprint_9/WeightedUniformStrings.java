package mfi.old_packages.tutorials.hacketrank.all_contests.world_codesprint_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightedUniformStrings {
	public static void main(String[] args){
		 Scanner in = new Scanner(System.in);
//			String s = "abccddde";
			String s = in.next();
			List lt = new ArrayList();
			for(int i=0;i<s.length();i++){
				
				int sum = s.charAt(i)-'a'+1;
				while(i < s.length()-1 && s.charAt(i+1) == s.charAt(i)){
					lt.add(sum);
					sum = sum+(s.charAt(i+1)-'a'+1);
					i++;
				}
				lt.add(sum);
			}
//			for(int i=0;i<lt.size();i++){
//				System.out.println(lt.get(i));
//			}
			
			
			int n = in.nextInt();
			for(int a0 = 0; a0 < n; a0++){
				int x = in.nextInt();
				// your code goes here
				if(lt.contains(x)){
					System.out.println("Yes");
				}else{
					System.out.println("No");
				}
			}
	}
}
