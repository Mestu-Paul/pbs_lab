import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }
    public int mul(int a, int b) throws RemoteException {
        return a * b;
    }
    public String div(int a, int b) throws RemoteException {
        if(b==0)return "Can't divide by 0";
        return String.valueOf((a * 1.0) / b);
    }
    public String mod(int a, int b) throws RemoteException {
        if(b==0)return "Can't divide by 0";
        return String.valueOf(a%b);
    }
}
