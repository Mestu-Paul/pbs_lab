import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    double radToDeg(double angle) throws RemoteException;
    double sin(double angle) throws RemoteException;
    double cos(double angle) throws RemoteException;
    double tan(double angle) throws RemoteException;
}
