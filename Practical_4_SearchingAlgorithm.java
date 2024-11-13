import java.util.Arrays;

public class SearchingAlgorithm {
    public int sequentialSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1; 
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int BestCase = 0;
        int AverageCase = 5000;
        int WorstCase = 10000;
        SearchingAlgorithm ss = new SearchingAlgorithm();
        int Arr[] = new int[10000];
        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = i;
        }
        //Best Case for Sequential Search : 
        long startTime = System.nanoTime();
        int best = ss.sequentialSearch(Arr, BestCase);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        if (best != -1) {
            System.out.println("element found at index " +best);
        } else {
            System.out.println("Element not found");
        }
        System.out.println("Execution time taken by best case: " +executionTime);

         //average case where target index at middle
         startTime = System.nanoTime();
         int average = ss.sequentialSearch(Arr, AverageCase);
         endTime = System.nanoTime();
         executionTime = endTime - startTime;
         if (average != -1) {
             System.out.println("element found at index " +average);
         } else {
             System.out.println("Element not found");
         }
         System.out.println("Execution time taken by average case: " +executionTime);

        //worst case where target index is last
        startTime = System.nanoTime();
        int worst = ss.sequentialSearch(Arr, WorstCase);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        if (worst != -1) {
            System.out.println("element found at index " +worst);
        } else {
            System.out.println("Element not found");
        }
        System.out.println("Execution time taken by worst case: " +executionTime);


        // Binary Search
        System.out.println("\nBinary Search:");
        Arrays.sort(Arr); 
        // System.out.println("Sorted array: " + Arrays.toString(Arr));
        SearchingAlgorithm bs = new SearchingAlgorithm();

        //best case for binary
        startTime = System.nanoTime();
        int Best = bs.sequentialSearch(Arr, BestCase);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        if (Best != -1) {
            System.out.println("element found at index " +Best);
        } else {
            System.out.println("Element not found");
        }
        System.out.println("Execution time taken by best case: " +executionTime);

         //average case for binary
       startTime = System.nanoTime();
       int Avg = bs.sequentialSearch(Arr, AverageCase);
       endTime = System.nanoTime();
       executionTime = endTime - startTime;
       if (Avg != -1) {
           System.out.println("element found at index " +Avg);
       } else {
           System.out.println("Element not found");
       }
       System.out.println("Execution time taken by average case: " +executionTime);

        //worst case for binary
        startTime = System.nanoTime();
        int Worst = bs.sequentialSearch(Arr, WorstCase);
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        if (Worst != -1) {
            System.out.println("element found at index " +Worst);
        } else {
            System.out.println("Element not found");
        }
        System.out.println("Execution time taken by worst case: " +executionTime);

    }
}
