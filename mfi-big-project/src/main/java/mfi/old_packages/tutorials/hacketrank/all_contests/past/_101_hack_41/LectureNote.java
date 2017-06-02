package mfi.old_packages.tutorials.hacketrank.all_contests.past._101_hack_41;

import java.util.Scanner;

import mfi.old_packages.toBeReviewedPkg.mfi.util.ioUtil.InputOutputUtil;
/*
3 2
101
1 3 
 * */
public class LectureNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.next();
        int friends[] = new int[k];
        for(int friends_i=0; friends_i < k; friends_i++){
            friends[friends_i] = in.nextInt();
        }
        boolean canTakeNote = false;
        InputOutputUtil.printArray(friends);
        for(int i=0;i<friends.length;i++){
        	if(!isSleeping(friends[i],s)){
        		canTakeNote = true;
        		break;
        	}
        	
        }
        System.out.println(canTakeNote?"YES":"NO");
        
	}
	private static boolean isSleeping(int ind, String s){
		return (s.charAt(ind-1) == '1')?true:false;
	}

}
