package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day12_Inheritance;

public class Student extends Person {
	private int[] testScores;
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	public Student(String firstName, String lastName, int id, int[] scores){
		super(firstName, lastName, id);
		this.testScores = scores;
	}
	public String calculate(){
		int res = 0;
		for(int i=0;i<testScores.length;i++){
			res += testScores[i];
		}
		res = res/testScores.length;
		String result = "";
		if(90 <= res && res <= 100){
			result = "O";
		}else if(80 <= res && res < 90){
			result = "E";
		}else if(70 <= res && res < 80){
			result = "A";
		}else if(55 <= res && res < 70){
			result = "P";
		}else if(40 <= res && res < 55){
			result = "D";
		}else if(res < 40){
			result = "T";
		}
		return result;
	}
}
