/**
 * Created with IntelliJ IDEA.
 * User: konstantin
 * Date: 9/29/13
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class EditDictionaryTable {

    public void CreateEDTable(Display display) {

        Shell shellED = new Shell(display);
        shellED.setLayout(new GridLayout());

        Table edTable = new Table(shellED, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
        edTable.setLinesVisible(true);
        edTable.setHeaderVisible(true);
        GridData dataTable = new GridData(SWT.FILL, SWT.FILL, true, true);
        edTable.setLayoutData(dataTable);


        String[] columnTitlesForTable = new String[]{"Original words", "Translate"};

        for (int i = 0; i < columnTitlesForTable.length; i++) {
            TableColumn column = new TableColumn(edTable, SWT.NONE);
            column.setText(columnTitlesForTable[i]);
            edTable.getColumn(i).pack();
        }

        TableItem itemTable1 = new TableItem(edTable,SWT.NONE);
        TableItem itemTable2 = new TableItem(edTable,SWT.NONE);
        TableItem itemTable3 = new TableItem(edTable,SWT.NONE);
        TableItem itemTable4 = new TableItem(edTable,SWT.NONE);

        itemTable1.setText(0,"Good");
        itemTable1.setText(1,"Хорошо");
        itemTable2.setText(0,"Thank you");
        itemTable2.setText(1,"Спасибо");
        itemTable3.setText(0,"Hello");
        itemTable3.setText(1,"Привет");
        itemTable4.setText(0,"Table");
        itemTable4.setText(1,"Таблица");


        for (int i = 0; i < columnTitlesForTable.length; i++) {
            edTable.getColumn(i).pack();
        }

        shellED.open();
        shellED.pack();
        while (!shellED.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}