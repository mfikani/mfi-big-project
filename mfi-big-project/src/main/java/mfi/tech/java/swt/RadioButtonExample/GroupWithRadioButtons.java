package mfi.tech.java.swt.RadioButtonExample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class GroupWithRadioButtons {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());


		// Create the first Group
		Group group1 = new Group(shell, SWT.SHADOW_IN);
		group1.setText("Who's your favorite?");
		group1.setLayout(new RowLayout(SWT.VERTICAL));
		new Button(group1, SWT.RADIO).setText("A");
		new Button(group1, SWT.RADIO).setText("B");
		new Button(group1, SWT.RADIO).setText("C");
		new Button(group1, SWT.RADIO).setText("D");


		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
