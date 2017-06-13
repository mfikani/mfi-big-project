package mfi.tech.java.swt.GridLayoutExample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class GridLayoutExample {

	private static GridData data_1;
	private static GridData data_2;

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setMinimumSize(new Point(123, 30));
		shell.setSize(126, 123);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		shell.setLayout(layout);

		GridData data = new GridData(GridData.FILL_BOTH);
		data.grabExcessHorizontalSpace = false;
		data.widthHint = 200;
		data.grabExcessVerticalSpace = false;
		Button one = new Button(shell, SWT.PUSH);
		one.setText("one");
		one.setLayoutData(data);

		data = new GridData(GridData.FILL_BOTH);
		Button two = new Button(shell, SWT.PUSH);
		two.setText("two");
		two.setLayoutData(data);
		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);

		data_2 = new GridData(GridData.FILL_BOTH);
		Button four = new Button(shell, SWT.PUSH);
		four.setText("four");
		four.setLayoutData(data_2);
		new Label(shell, SWT.NONE).setText("111");
		new Label(shell, SWT.NONE).setText("222");
		new Label(shell, SWT.NONE).setText("333");

		new Label(shell, SWT.NONE).setText("444");
		new Label(shell, SWT.NONE).setText("555");

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setText("New Button");

		data_1 = new GridData(GridData.FILL_BOTH);
		data_1.grabExcessVerticalSpace = false;
		data_1.grabExcessHorizontalSpace = false;
		Button three = new Button(shell, SWT.PUSH);

		three.setText("three");
		three.setLayoutData(data_1);

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
