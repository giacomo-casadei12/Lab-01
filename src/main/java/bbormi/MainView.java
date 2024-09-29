package bbormi;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class MainView {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {

        View app = new ViewImpl();
        SwingUtilities.invokeAndWait(() -> app.setVisibleD(true));
    }
}
