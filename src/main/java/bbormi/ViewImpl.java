package bbormi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ViewImpl implements View {

    Controller controller;

    public ViewImpl() {

        try {

            Registry registry = LocateRegistry.getRegistry(1888);
            controller = (Controller) registry.lookup("Controller");

            JFrame f = getjFrame();

            f.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent ev) {
                    System.exit(-1);
                }
            });
            
            f.setVisible(true);

            /*setLayout(new BorderLayout());            add(f, BorderLayout.NORTH);*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

    }

    private JFrame getjFrame() {
        JTextField state = new JTextField(16);
        state.setEditable(false);
        JButton button = new JButton("Basic Update");
        button.addActionListener(e -> {
            try {
                state.setText("State value: " + controller.increment());
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        });

        JFrame f = new JFrame("RMI APP");

        JTextField t = new JTextField(16);

        JButton b = new JButton("Custom Update");
        b.addActionListener(e -> {
            try {
                state.setText("State value: " + controller.customIncrement(Integer.parseInt(t.getText())));
                t.setText("");
            } catch (RemoteException | NumberFormatException ex) {
                throw new RuntimeException(ex);
            }
        });

        JPanel p = new JPanel();

        p.add(t);
        p.add(b);

        JPanel p1 = new JPanel();
        p1.add(state);

        f.getContentPane().add(p1, BorderLayout.NORTH);

        // add panel to frame
        f.getContentPane().add(p, BorderLayout.CENTER);

        // set the size of frame
        f.setSize(500, 200);

        JPanel panel = new JPanel();
        panel.add(button);

        f.getContentPane().add(panel, BorderLayout.SOUTH);
        return f;
    }

}
