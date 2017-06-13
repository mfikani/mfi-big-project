package mfi.tech.java.swt.RadioButtonExample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RadioButtonExample {

	public static void main(String[] args) {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setLayout(new GridLayout(3, true));

	    // Create three radio buttons
	    new Button(shell, SWT.RADIO).setText("Radio 11");
	    new Button(shell, SWT.RADIO).setText("Radio 2");
	    new Button(shell, SWT.RADIO).setText("Radio 3");

	    Button b1 = new Button(shell, SWT.RADIO);
	    b1.setText("Radio Selected");
	    b1.setSelection(true);
	    

	    shell.pack();
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	  }

}
