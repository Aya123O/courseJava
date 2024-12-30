
import java.util.Scanner;
import lab4.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       
        System.out.print("Enter the value of a: ");
        double a = input.nextDouble();

        System.out.print("Enter the value of b: ");
        double b = input.nextDouble();

        System.out.print("Enter the value of c: ");
        double c = input.nextDouble();

      
        QuadraticSolver solver = new QuadraticEquationSolver();
        solver.solve(a, b, c);

        //////////////////////////////////////////////////////////////////////////////////
        TemperatureConverter temperature  = new TemperatureConverter();
        double myvar=  temperature.apply(25.5);
          System.out.println("the value of Temperature :");
         System.out.println(myvar);
    
    }
}

