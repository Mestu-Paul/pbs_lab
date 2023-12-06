import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        
        Calculator calculator = (Calculator) registry.lookup("CalculatorService");
        
        int result = calculator.add(5, 3);
	System.out.println("Sum of " + a + " and " + b + " is: " + result);
    }
}
