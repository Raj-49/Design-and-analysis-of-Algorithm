/*Write a program to sort given elements of an array in ascending order using selection sort. 
Analyze the time complexity for best, average and worst case. */
import java.util.Random;

public class SelectionSort {
    void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] and arr[minIndex]
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random r = new Random();
        SelectionSort S = new SelectionSort();
        // Best Case: Already sorted array
        int bestCaseArr []= new int[10000];
        for (int i = 0; i < bestCaseArr.length; i++) {
            bestCaseArr[i] = i;
        }
        System.out.println("Best Case: Already sorted array");
        System.out.println("Original array:");
        S.printArray(bestCaseArr);

        long startTime = System.currentTimeMillis();
        S.selectionSort(bestCaseArr);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        S.printArray(bestCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        System.out.println();

        // Average Case: Randomly ordered array
        int[] averageCaseArr = new int[10000];
        for (int i = 0; i < averageCaseArr.length; i++) {
            averageCaseArr[i] = r.nextInt(10000);
        }
        System.out.println("Average Case: Randomly ordered array");
        System.out.println("Original array:");
        S.printArray(averageCaseArr);

        startTime = System.currentTimeMillis();
        S.selectionSort(averageCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        S.printArray(averageCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        System.out.println();

        // Worst Case: Reverse sorted array
        int[] worstCaseArr = new int[10000];
        int n = 0;
        for (int i = 9999; i >= 0; i--) {
            worstCaseArr[n] = i;
            n++;
        }
        System.out.println("Worst Case: Reverse sorted array");
        System.out.println("Original array:");
        S.printArray(worstCaseArr);

        startTime = System.currentTimeMillis();
        S.selectionSort(worstCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        S.printArray(worstCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}
