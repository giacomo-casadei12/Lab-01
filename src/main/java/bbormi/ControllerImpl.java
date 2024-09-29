package bbormi;

import java.rmi.RemoteException;

public class ControllerImpl extends java.rmi.server.UnicastRemoteObject implements Controller {

    Model model;
    final int BASE_INCREMENT = 1;

    public ControllerImpl(Model model) throws RemoteException {
        super();
        this.model = model;
        this.model.attachController(this);
    }

    @Override
    public int increment() {
        return this.model.addValue(BASE_INCREMENT);
    }

    @Override
    public int customIncrement(int value) throws RemoteException {
        return this.model.addValue(value);
    }

}
