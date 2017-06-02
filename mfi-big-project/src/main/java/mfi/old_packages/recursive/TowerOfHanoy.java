package mfi.old_packages.recursive;

public class TowerOfHanoy {

	/**
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hanoy h = new Hanoy();
		
	}
	static class Hanoy{
		private int diskNumber;
		private String p1;
		private String p2;
		private String p3;
		
		public int solveHanoy(String source, String destination, String temp, int diskNbr){
			if(diskNbr == 1){
				return 0;
			}else{
				return solveHanoy(source, temp, destination,diskNbr-1);
			}
		}
	}
}
