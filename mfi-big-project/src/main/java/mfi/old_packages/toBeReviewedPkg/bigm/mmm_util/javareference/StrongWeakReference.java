package mfi.old_packages.toBeReviewedPkg.bigm.mmm_util.javareference;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Tutorial  : http://www.programmr.com/blogs/what-every-java-developer-should-know-strong-and-weak-references
 * @author mfi
 *
 */
public class StrongWeakReference
{

	public static void main(String[] args)
	{
		// STRONG Reference (normal reference, used always ) 
		Widget w = new Widget(0); 
		/*
		 * Note
		 * A Widget object is created on the heap, and the variable w holds a reference to that object. 
		 * As long as the variable w is active, the object which it points to (Widget) will not be garbage collected.
		 * */
		
		// WEAK Reference
		WeakReference<String> wr = new WeakReference<String>(new String("abc"));
		
		/*
		 * Note
		 * Objects referenced by them may be garbage collected -- if the JVM runs short of memory -- even when they are being used. Creating a weak reference is a way of telling the JVM:
		 * Look dude, I am creating this object as a weak reference. 
		 * Even though I need it, feel free to garbage collect it if you run out of memory. I know this object can be GC'd any time and am prepared to deal with it.
		 * */
		
		/*
		 * To get the String back 
		 * 
		 * String s = wr.get();
			if(s != null ) {
			    // great the weak ref has not been garbage collected
			} else {
			    // oops the weak ref was garbage collected... now I will have to create another one
			}
		 * */
		
		/***************************************************************************/
		// The Example
		
		// Ask the user how many Widget objects they want to create
		// Remember each Widget takes a little over 1MB
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many objects do you want to create ?");
		int count = scanner.nextInt();
		
		Map<Integer, WeakReference<Widget>> weakWidgets = new HashMap<Integer, WeakReference<Widget>>();
		System.out.println("Creating "+count+" widgets as weak references.");
		
		for(int i=0;i<count;i++){
			weakWidgets.put(i, new WeakReference<Widget>(new Widget(i)));
		}
		
		// Here's how we access items from a WeakReference
		for(int i=0;i<count;i++){
			WeakReference<Widget> weakRef = weakWidgets.get(i);
			Widget ww = weakRef.get();
			// Find out if the WeakWidget is still there or has it been GD'd  (GD = garbage collected)
			if(ww == null){
				System.out.println("Oops WeakWidget "+i+" was garbage collected.");
			}else{
				System.out.println("Awesome WeakWidget "+i+" is still around. Let's use it");
			}
		}
		
	}

}

class Widget{
	private byte buff[];
	private int id;
	
	public Widget(int id){
		// Each Widget object takes approximately 1MB
		this.buff = new byte[1024 * 1000];
		this.id = id;
	}
}