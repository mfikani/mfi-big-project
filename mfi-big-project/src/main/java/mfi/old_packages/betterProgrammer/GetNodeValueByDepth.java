package mfi.old_packages.betterProgrammer;

import org.w3c.dom.Node;

public class GetNodeValueByDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
         * construct tree
         *                                    sum of node's value   
         *              5          depth 0 ==> 5
         *             / \               
         *           3    10       depth 1 ==> 13
         *          / \   / \
         *         2  4   6  11    depth 2 ==> 23
         *               / \
         *              7   9      depth 3 ==> 16
         *            
         *                         depth 4 ==> null
         *           
         */
		

	}
//	public int getNodeValueByDepth(Node n, int level) {
//
//        int sum = 0;
//
//        if(level == 0) {
//            return sum + n.data;
//        }
//        else if(n.left != null) {
//            return sum += getNodeValueByDepth(n.left, level-1);
//        }
//        else if(n.right != null) {
//            return sum += getNodeValueByDepth(n.right, level-1);
//        }
//        else {
//            return sum + 0;
//        }
//
//    }

}
