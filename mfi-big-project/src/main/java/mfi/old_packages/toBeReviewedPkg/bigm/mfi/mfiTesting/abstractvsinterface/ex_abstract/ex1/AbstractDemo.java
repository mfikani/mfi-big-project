package mfi.old_packages.toBeReviewedPkg.bigm.mfi.mfiTesting.abstractvsinterface.ex_abstract.ex1;

public class AbstractDemo {

	public static void main(String[] args) {
		
		/*Following is not allowed and would raise error*/
//		Employee e = new Employee("Miled M", "Leb", 35);
//		
//		System.out.println("\n Call mailCheck using Employee reference--");
//	    e.mailCheck();
		
		Salary s = new Salary("Miled F", "Leb", 3, 10000.00);
		Employee e = new Salary("Jihad F", "France", 2, 2500.00);
		
		s.computePay();
		
		System.out.println("Call mailCheck using Salary reference --");
		s.mailCheck();
		
		System.out.println("\n Call mailCheck using Employee reference --");
		e.mailCheck();
	}
}
