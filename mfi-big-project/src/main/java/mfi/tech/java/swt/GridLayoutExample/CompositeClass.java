package mfi.tech.java.swt.GridLayoutExample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CompositeClass {
	public static void main(String[] args) {
	    Display display = new Display();
	    final Shell shell = new Shell(display);
	    shell.setSize(300, 300);
	    shell.setLayout(new RowLayout());

	    shell.setText("Composite Example");

	    final Composite composite = new Composite(shell, SWT.NONE);
	    GridLayout gridLayout = new GridLayout();
	    gridLayout.numColumns = 4;
	    composite.setLayout(gridLayout);

	    for (int loopIndex = 0; loopIndex < 28; loopIndex++) {
	      Label label = new Label(composite, SWT.SHADOW_NONE);
	      label.setText("Label " + loopIndex);
	    }

	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch())
	        display.sleep();
	    }
	    display.dispose();
	  }
}
