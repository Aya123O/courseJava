public class LoopString {
    public static void main(String[] args) {
  
        if (args.length == 2) {
            try {
          
                int loop = Integer.parseInt(args[0]);
                
        
                if (loop <= 0) {
                    System.out.println("The first argument must be a positive number.");
                    return;
                }
                
               
                if (args[1].isEmpty()) {
                    System.out.println("The second argument cannot be an empty string.");
                    return;
                }
                
             
                if (loop > 100) {
                    System.out.println("The number in the first argument should not exceed 100.");
                    return;
                }
                
        
                for (int i = 0; i < loop; i++) {
                    System.out.println(args[1]);
                }
            } catch (NumberFormatException e) {
          
                System.out.println("The first argument must be a valid number.");
            }
        } else {
            System.out.println("Please provide exactly two arguments: a positive number and a string.");
        }
    }
}

