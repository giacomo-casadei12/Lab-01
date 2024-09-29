package bbormi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainModelController {

    static public void main(String[] args) {
        Model model = new ModelImpl();
        //System.setProperty("java.rmi.server.hostname", "localhost");
        try{
            Controller controller = new ControllerImpl(model);
            Registry registry = LocateRegistry.createRegistry(1888);
            registry.rebind("Controller", controller);
            //Naming.rebind("Controller", controller);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
