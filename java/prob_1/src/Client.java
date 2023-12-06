import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        
        Calculator calculator = (Calculator) registry.lookup("CalculatorService");
        
        System.out.println("Client is running:");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter angle (in degree): ");

        try {
            double b = sc.nextDouble();
            System.out.println("Select an operation:");
            System.out.println("1.sin \n");
            System.out.println("2.cos \n");
            System.out.println("3.tan \n");

            double a = calculator.radToDeg(b);
            int op = sc.nextInt();
            if(op==1){
                System.out.println("sin("+b+") = "+calculator.sin(a));
            }
            else if(op==2){
                System.out.println("cos("+b+") = "+calculator.cos(a));
            }
            else{
                System.out.println("tan("+b+") = "+calculator.tan(a));
            }


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception: "+e.getMessage());
        }

        sc.close();

    }
}
