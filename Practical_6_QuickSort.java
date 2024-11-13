import java.util.Random;

public class QuickSort {
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low + 1;
        int j = high;

        while (i <= j) {
            while (i <= j && array[i] <= pivot) {
                i++;
            }

            while (i <= j && array[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        array[low] = array[j];
        array[j] = pivot;

        return j;
    }

    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        Random r = new Random();

        // Best Case: Already sorted array
        int bestCaseArr[] = new int[10000];
        for (int i = 0; i < bestCaseArr.length; i++) {
            bestCaseArr[i] = i;
        }
        System.out.println("Best Case: Already sorted array");
        System.out.println("Original array:");
        q.printArray(bestCaseArr);

        long startTime = System.currentTimeMillis();
        q.quickSort(bestCaseArr);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        q.printArray(bestCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        System.out.println();

        // Average Case: Randomly ordered array
        int[] averageCaseArr = new int[10000];
        for (int i = 0; i < averageCaseArr.length; i++) {
            averageCaseArr[i] = r.nextInt(10000);
        }
        System.out.println("Average Case: Randomly ordered array");
        System.out.println("Original array:");
        q.printArray(averageCaseArr);

        startTime = System.currentTimeMillis();
        q.quickSort(averageCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        q.printArray(averageCaseArr);
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
        q.printArray(worstCaseArr);

        startTime = System.currentTimeMillis();
        q.quickSort(worstCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        q.printArray(worstCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
    }
}