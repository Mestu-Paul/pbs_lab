import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        
        Calculator calculator = (Calculator) registry.lookup("CalculatorService");
        
        System.out.println("Client is running:");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two number: ");

        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Select an operation:");
            System.out.println("1.addition \n");
            System.out.println("2.Substraction \n");
            System.out.println("3.Multiplication \n");
            System.out.println("4.Division \n");
            System.out.println("5.Modulus \n");

            int op = sc.nextInt();
            if(op==1){
                System.out.println(a+" + "+b+" = "+calculator.add(a, b));
            }
            else if(op==2){
                System.out.println(a+" - "+b+" = "+calculator.sub(a, b));
            }
            else if(op==3){
                System.out.println(a+" * "+b+" = "+calculator.mul(a, b));
            }
            else if(op==4){
                System.out.println(a+" / "+b+" = "+calculator.div(a, b));
            }
            else{
                System.out.println(a+" % "+b+" = "+calculator.mod(a, b));
            }


        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Exception: "+e.getMessage());
        }

        sc.close();

    }
}
