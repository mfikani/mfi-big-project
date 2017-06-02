package mfi.old_packages.thread.ex3_deadlock;
// running this class will lead to Deadlock, program will never 
/*
 - using synchronized in method bow and bowback output is :  
  
  Miled: Jihad has bowed to me!
  Jihad: Miled has bowed to me!
  
 
 - without synchronized key in methods bow and bowback, output is :  
 
 Miled: Jihad has bowed to me!
 Jihad: Miled has bowed to me!
 Jihad: Miled has bowed back to me!
 Miled: Jihad has bowed back to me!
  
 * */
public class Deadlock {
	static class Friend{
		private final String name;
		
		public Friend(String name){
			this.name = name;
		}
		
		public String getName(){
			return this.name;
		}
		
		public synchronized void bow(Friend bower){
			System.out.format("%s: %s"+ " has bowed to me!%n",this.name, bower.getName());
			bower.bowBack(this);			
		}
		
		public synchronized void bowBack(Friend bower){
			System.out.format("%s: %s"+ " has bowed back to me!\n", this.name, bower.getName());
		}
	}
	
	public static void main(String[] args){
		final Friend miled = new Friend("Miled");
		final Friend jihad = new Friend("Jihad");
		
		new Thread(new Runnable(){
			public void run(){
				miled.bow(jihad);
			}
		}).start();	
		
		new Thread(new Runnable(){
			public void run(){
				jihad.bow(miled);
			}
		}).start();
	}
}
