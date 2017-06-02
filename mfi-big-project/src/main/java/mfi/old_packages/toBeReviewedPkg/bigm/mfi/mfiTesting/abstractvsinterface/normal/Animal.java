package mfi.old_packages.toBeReviewedPkg.bigm.mfi.mfiTesting.abstractvsinterface.normal;

public class Animal {
	public Animal(){
		System.out.println("I am an Animal Class");
	}
	
	public void likeToEat(){
		System.out.println(this.name+" like to Eat any kind of food");
	}
	
	private String color;
	private int numberOfLegs;
	private String name = "Animal";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	public void setNumberOfLegs(int numberOfLegs) {
		this.numberOfLegs = numberOfLegs;
	}	
}
