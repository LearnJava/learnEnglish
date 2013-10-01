/**
 * Created with IntelliJ IDEA.
 * User: konstantin
 * Date: 9/29/13
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class PropertiesWindow {

    public PropertiesWindow(Display display) {

        Shell shellProperties = new Shell(display);
        GridLayout gridLayout = new GridLayout();
        gridLayout.numColumns = 2;
        shellProperties.setLayout(gridLayout);

        Group grouptime = new Group(shellProperties,SWT.BORDER);
        grouptime.setText("Time setup");
        grouptime.setLayout(new RowLayout());

        Label label = new Label(grouptime, SWT.NONE);
        label.setText("Sleep Time");

        Spinner spinner = new Spinner(grouptime, SWT.NONE);
        spinner.setMinimum(0);
        spinner.setMaximum(100000);
        spinner.setSelection(5000);
        spinner.setIncrement(1000);
        spinner.setPageIncrement(100);
        Rectangle clientArea = shellProperties.getClientArea();
        spinner.setLocation(clientArea.x, clientArea.y);

        Group groupFont = new Group(shellProperties,SWT.NONE);
        GridLayout fontLayout = new GridLayout();
        fontLayout.numColumns = 2;
        groupFont.setLayout(fontLayout);
        groupFont.setText("Настройки шрифта");

        Label fontColor = new Label(groupFont,SWT.NONE);
        Text textFontColor = new Text(groupFont, SWT.SIMPLE);
        textFontColor.setText("RED");

        Label fontSize = new Label(groupFont,SWT.NONE);
        fontColor.setText("Font Color");
        fontSize.setText("Font Size");
        Text textFontSize = new Text(groupFont, SWT.SIMPLE);
        textFontSize.setText("19");

        shellProperties.pack();
        shellProperties.open();

        while (!shellProperties.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}