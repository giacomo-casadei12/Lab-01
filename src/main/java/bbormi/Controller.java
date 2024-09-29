package bbormi;

public interface Controller extends java.rmi.Remote {

    int increment() throws java.rmi.RemoteException;

    int customIncrement(int value) throws java.rmi.RemoteException;

}
