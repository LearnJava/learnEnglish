import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.*;

public class StartHereSWT {

    private static TrayItem item;
    private static Image image = null;

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new StartHereSWT().CreateShell(display);

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        if (image != null)
            image.dispose();
        display.dispose();
    }

    private Shell CreateShell(final Display display) {

        Shell shell = new Shell(display);

        final ToolTip tip = new ToolTip(shell, SWT.BALLOON | SWT.ICON_INFORMATION);
        tip.setMessage("Info from DB here");
        Tray tray = display.getSystemTray();
        if (tray != null) {
            item = new TrayItem(tray, SWT.NONE);
            image = new Image(display, "images/icons/bulb.gif");
            item.setImage(image);
            tip.setText("Notification from a tray item");
            item.setToolTip(tip);
        } else {
            tip.setText("Notification from anywhere");
            tip.setLocation(400, 400);
        }

        final Menu menu = new Menu(shell, SWT.POP_UP);

        MenuItem miShowToolTip = new MenuItem(menu, SWT.PUSH);
        miShowToolTip.setText("Show ToolTip");
        miShowToolTip.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                System.out.println("selection " + event.widget);
                tip.setVisible(true);
            }
        });

        MenuItem miEditDictionary = new MenuItem(menu, SWT.PUSH);
        miEditDictionary.setText("Edit Dictionary");
        miEditDictionary.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                System.out.println("selection " + event.widget);
                new EditDictionaryTable().CreateEDTable(display);
            }
        });

        MenuItem miProperties = new MenuItem(menu, SWT.PUSH);
        miProperties.setText("Properties");
        miProperties.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                System.out.println("selection " + event.widget);
                new PropertiesWindow(display);
            }
        });

        MenuItem miExit = new MenuItem(menu, SWT.PUSH);
        miExit.setText("Exit");
        miExit.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                System.out.println("selection " + event.widget);
                display.dispose();
            }
        });

        item.addListener(SWT.MenuDetect, new Listener() {
            public void handleEvent(Event event) {
                menu.setVisible(true);
            }
        });

        tip.setVisible(true);
        shell.pack();

        return shell;
    }
}