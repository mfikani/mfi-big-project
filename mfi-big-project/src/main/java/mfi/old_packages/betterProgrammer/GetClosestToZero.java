package mfi.old_packages.betterProgrammer;

public class GetClosestToZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-5,2,-3};
		System.out.println(getClosestToZero(a)+"");
	}
	
	
	public static int getClosestToZero(int[] a) {
        /*
          Please implement this method to
          return the number in the array that is closest to zero.
          If there are two equally close to zero elements like 2 and -2
          - consider the positive element to be "closer" to zero.
         */
		int temp= 0;
		if(a!=null && a.length>0){
			temp = a[0];
			for(int i=1;i<a.length;i++){
				if(Math.abs(a[i]) < Math.abs(temp)){
					temp = a[i];
				}
			}
		}
		return temp;
    }

}
