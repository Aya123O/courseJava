package lab4 ;
public class QuadraticEquationSolver implements QuadraticSolver {

    @Override
    public void solve(double a, double b, double c) {
    
    calc(a,b,c);
    }
    private void  calc(double a, double b, double c){
    double d = b * b - 4.0 * a * c; 
        
        if (d > 0.0) {
            double r1 = (-b + Math.sqrt(d)) / (2.0 * a);
            double r2 = (-b - Math.sqrt(d)) / (2.0 * a);
            System.out.println("The roots are " + r1 + " and " + r2);
        } else if (d == 0.0) {
            double r1 = -b / (2.0 * a);
            System.out.println("The root is " + r1);
        } else {
            System.out.println("Roots are not real.");
        }
    
    }
        
    
}

