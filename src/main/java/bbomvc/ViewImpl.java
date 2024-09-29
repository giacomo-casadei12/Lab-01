package bbomvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewImpl extends JFrame implements View {

    Controller controller;

    public ViewImpl(Controller controller) {
        super("My BBoM App");
        this.controller = controller;
        setSize(300, 70);
        setResizable(false);

        JButton button = new JButton("Update");
        button.addActionListener(e -> controller.increment());

        JPanel panel = new JPanel();
        panel.add(button);

        setLayout(new BorderLayout());
        add(panel,BorderLayout.NORTH);

        controller.registerView(this);

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

    @Override
    public void updateView(int state) {
        log("State value: " + state);
    }

    private void log(String msg) {
        System.out.println("[Output] " + msg);
    }

}
