package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day14_Scope;

public class Difference {
	private int[] elements;
	public int maximumDifference;
	
	Difference(int[] a){
		elements = a;
	}
	
	public int computeDifference(){
		for(int i=0;i<elements.length;i++){
			for(int j=0;j<elements.length;j++){
				if(maximumDifference < Math.abs(elements[i]-elements[j])){
					maximumDifference = Math.abs(elements[i]-elements[j]);
				}
			}			
		}
		return maximumDifference;
		
	}
}
