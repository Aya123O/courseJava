import java.io.*;

 public class BinarySearch {


    int binarySearch(int arr[], int x) {
        int low = 0, high = arr.length - 1;
        
  
        long startBinarySearchTime = System.nanoTime();

        while (low <= high) {
            int mid = low + (high - low) / 2;

      
            if (arr[mid] == x) {
                long endBinarySearchTime = System.nanoTime();
                System.out.println("Time for binary search: " + (endBinarySearchTime - startBinarySearchTime) + " ns");
                return mid;
            }

   
            if (arr[mid] < x) {
                low = mid + 1;
            } 
   
            else {
                high = mid - 1;
            }
        }

        long endBinarySearchTime = System.nanoTime();
        System.out.println("Time for binary search: " + (endBinarySearchTime - startBinarySearchTime) + " ns");
        
      
        return -1;
    }


    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        
    
        int arr[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; 
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty or null.");
            return;
        }

 
        int x = 70;
        int result = ob.binarySearch(arr, x);
        
 
        if (result == -1)
            System.out.println("Element is not present in array");
        else
            System.out.println("Element is present at index " + result);
    }
}

