import java.util.Random;

public class MergeSort {
    public void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        for(int i=0;i<mid;i++){
            left[i]=array[i];
        }
        for(int i=mid;i<array.length;i++){
            right[i-mid]=array[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }
    private void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }
    void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        Random r = new Random();
        
        // Best Case: Already sorted array
        int bestCaseArr[] = new int[100000];
        for (int i = 0; i < bestCaseArr.length; i++) {
            bestCaseArr[i] = i;
        }
        System.out.println("Best Case: Already sorted array");
        System.out.println("Original array:");
        m.printArray(bestCaseArr);

        long startTime = System.currentTimeMillis();
        m.mergeSort(bestCaseArr);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        m.printArray(bestCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        System.out.println();

        // Average Case: Randomly ordered array
        int[] averageCaseArr = new int[100000];
        for (int i = 0; i < averageCaseArr.length; i++) {
            averageCaseArr[i] = r.nextInt(10000);
        }
        System.out.println("Average Case: Randomly ordered array");
        System.out.println("Original array:");
        m.printArray(averageCaseArr);

        startTime = System.currentTimeMillis();
        m.mergeSort(averageCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        m.printArray(averageCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        System.out.println();

        // Worst Case: Reverse sorted array
        int[] worstCaseArr = new int[100000];
        int n = 0;
        for (int i = 9999; i >= 0; i--) {
            worstCaseArr[n] = i;
            n++;
        }
        System.out.println("Worst Case: Reverse sorted array");
        System.out.println("Original array:");
        m.printArray(worstCaseArr);

        startTime = System.currentTimeMillis();
        m.mergeSort(worstCaseArr);
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println("Sorted array:");
        m.printArray(worstCaseArr);
        System.out.println("Execution time: " + executionTime + " milliseconds");
        System.out.println();
    }
}