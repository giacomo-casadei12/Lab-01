package bbomvc;

import javax.swing.*;

public class Main {
    static public void main(String[] args) throws Exception {
        Model model = new ModelImpl();
        Controller controller = new ControllerImpl(model);
        View app = new ViewImpl(controller);
        SwingUtilities.invokeAndWait(() -> app.setVisibleD(true));
    }
}
