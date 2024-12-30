import java.util.Random;

public class MinMaxArr {
    public static void main(String[] args) {
        int arr[] = new int[1000]; 

        
       
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2001) - 1000; 
        }

      

        long startMinMaxBeforeTime = System.nanoTime();

        int minBeforeSort = arr[0];
        int maxBeforeSort = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minBeforeSort) {
                minBeforeSort = arr[i];
            }
            if (arr[i] > maxBeforeSort) {
                maxBeforeSort = arr[i];
            }
        }

       
        long endMinMaxBeforeTime = System.nanoTime();

        System.out.println("Before sorting:");
        System.out.println("Min: " + minBeforeSort);
        System.out.println("Max: " + maxBeforeSort);
     
        System.out.println("Time for finding min and max (before sorting): " +
                           (endMinMaxBeforeTime - startMinMaxBeforeTime) + " ns");


    
    }
}

