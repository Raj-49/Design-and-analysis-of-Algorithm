/*Write a program to sort given elements of an array in ascending order using bubble sort. 
Analyze the time complexity for best, average and worst case. */
import java.util.Random;

public class BubbleSort {
    void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
        BubbleSort B = new BubbleSort();
        // Best Case: Already sorted array
        int bestCaseArr []= new int[10000];
        for (int i = 0; i < bestCaseArr.length; i++) {
            bestCaseArr[i] = i;
        }
        System.out.println("Best Case: Already sorted array");
        System.out.println("Original array:");
        B.printArray(bestCaseArr);

        long startTime = System.currentTimeMillis();
        B.bubbleSort(bestCaseArr);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        B.printArray(bestCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        System.out.println();

        // Average Case: Randomly ordered array
        int[] averageCaseArr = new int[10000];
        for (int i = 0; i < averageCaseArr.length; i++) {
            averageCaseArr[i] = r.nextInt(10000);
        }
        System.out.println("Average Case: Randomly ordered array");
        System.out.println("Original array:");
        B.printArray(averageCaseArr);

        startTime = System.currentTimeMillis();
        B.bubbleSort(averageCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        B.printArray(averageCaseArr);
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
        B.printArray(worstCaseArr);

        startTime = System.currentTimeMillis();
        B.bubbleSort(worstCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        B.printArray(worstCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}
