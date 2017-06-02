package mfi.old_packages.tutorials.hacketrank.dashboard.java.introduction.java_int_to_string;

import java.security.Permission;
import java.util.Scanner;

public class JavaIntToString {

	public static void main(String[] args) {
		DoNotTerminate.forbidExit();
		
//		Scanner sc = new Scanner(System.in);
//		while(sc.next() !="n"){
			doTest();
//			System.out.println("\nwould you like to try again (y/n)? \n");
//		}
//		sc.close();
	}
	
	private static void doTest(){
		DoNotTerminate.forbidExit();
		
		try{

			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.close();
			String s = String.valueOf(n);
			if(n == Integer.parseInt(s)){
				System.out.println("Good job");
			}else{
				System.out.println("Wrong answer.");
			}
		}catch(DoNotTerminate.ExitTrappedException e){
			System.out.println("unsuccessful termination");
		}
	}

}

//the following class will prevent you from terminating the code using exit(0)! 
class DoNotTerminate{
	public static class ExitTrappedException extends SecurityException{
		private static final long serialVersionUID = 1;
	}
	
	public static void forbidExit(){
		final SecurityManager securityManager = new SecurityManager(){
			
			@Override
			public void checkPermission(Permission permission){
				if(permission.getName().contains("exitVM")){
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);		
	}
	
}