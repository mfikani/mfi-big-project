package mfi.tech.java.swt.RadioButtonExample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class RadioButtonDemoManyGroup {

	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT Radio Button (o7planning.org)");

		RowLayout rowLayout = new RowLayout();
		rowLayout.marginLeft = 10;
		rowLayout.marginTop = 10;
		rowLayout.spacing = 15;
		shell.setLayout(rowLayout);

		// Create a group to contain 2 radio (Male & Female)
		// Tạo một nhóm để chứa 2 radio (Male & Female).
		Group genderGroup = new Group(shell, SWT.NONE);
		genderGroup.setLayout(new RowLayout(SWT.HORIZONTAL));

//		Label label = new Label(genderGroup, SWT.NONE);
//		label.setText("Your gender: ");

		Button buttonMale = new Button(genderGroup, SWT.RADIO);
		buttonMale.setText("Male");

		Button buttonFemale = new Button(genderGroup, SWT.RADIO);
		buttonFemale.setText("Female");

		// Group
		Group titleGroup = new Group(shell, SWT.NONE);
		titleGroup.setLayout(new RowLayout(SWT.VERTICAL));
		titleGroup.setText("Select title");

		Button buttonMr = new Button(titleGroup, SWT.RADIO);
		buttonMr.setText("Mr");

		Button buttonMrs = new Button(titleGroup, SWT.RADIO);
		buttonMrs.setText("Mrs");

		Button buttonMs = new Button(titleGroup, SWT.RADIO);
		buttonMs.setText("Ms");

		shell.setSize(400, 250);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}


}
