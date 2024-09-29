package bbormi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ViewImpl extends JFrame implements View {

    Controller controller;

    public ViewImpl() {
        super("My BBoM App");
        setSize(300, 70);
        setResizable(false);

        try {

            Registry registry = LocateRegistry.getRegistry(1888);
            controller = (Controller) registry.lookup("Controller");

            JButton button = new JButton("Update");
            button.addActionListener(e -> {
                try {
                    log("State value: " + controller.increment());
                } catch (RemoteException ex) {
                    throw new RuntimeException(ex);
                }
            });

            JPanel panel = new JPanel();
            panel.add(button);

            setLayout(new BorderLayout());
            add(panel, BorderLayout.NORTH);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }
        });
    }

    @Override
    public void setVisibleD(boolean b) {
        this.setVisible(b);
    }

    private void log(String msg) {
        System.out.println("[Output] " + msg);
    }

}
