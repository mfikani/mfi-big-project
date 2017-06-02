package mfi.old_packages.toBeReviewedPkg.bigm.mfi.mfiTesting.abstractvsinterface.ex_abstract;

/*
 URL : http://www.tutorialspoint.com//java/java_abstraction.htm 
  
In Abstraction (interface or abstract) :
- user will have the information on what the object does instead of how it does it
- Abstract classes may or may not contain abstract methods ie., methods with out body ( public void get(); )
- But, if a class have at least one abstract method, then the class must be declared abstract.
- If a class is declared abstract it cannot be instantiated.
- To use an abstract class you have to inherit it from another class, provide implementations to the abstract methods in it.  
* */

/***
 * mfi
 */

public abstract class AbstractClassDef {
	
	abstract void doTest();
	
	private void doTest2(){
		System.out.println("AbstractClassDef doTest2");
		
	};
	
	void doTest3(){
		//AbstractClassDef a = new AbstractClassDef(); 
		
	};
}

abstract class ChildClass extends AbstractClassDef{
	
	private void doTest2(){
		System.out.println("ChildClass doTest2");
	}
}



