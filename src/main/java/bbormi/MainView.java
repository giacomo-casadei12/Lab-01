package bbormi;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class MainView {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {

        new ViewImpl();
        SwingUtilities.invokeAndWait(() -> {});
    }
}
