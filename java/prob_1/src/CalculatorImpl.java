import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    public double radToDeg(double angle) throws RemoteException {
        return (Math.PI/180.0)*angle;
    }
    public double sin(double angle) throws RemoteException {
        return Math.sin(angle);
    }

    public double cos(double angle) throws RemoteException {
        return Math.cos(angle);
    }

    public double tan(double angle) throws RemoteException {
        return Math.tan(angle);
    }
}
