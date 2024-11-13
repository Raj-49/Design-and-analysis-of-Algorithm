import java.util.*;

public class HeapSort {

    public void heapify(int arr[], int size, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[root]) {
            root = left;
        }
        if (right < size && arr[right] > arr[root]) {
            root = right;
        }
        if (root != i) {
            int temp = arr[i];
            arr[i] = arr[root];
            arr[root] = temp;
            heapify(arr, size, root);
        }
    }

    public void sort(int arr[]) {
        int size = arr.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }
        for (int i = size - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public void display(int arr[]) {
        int size = arr.length;
        for (int i = 0; i < size; ++i) {
            System.out.print(arr[i] + " ");
            // System.out.println();
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 5, 8, 1, 3, 6 };
        // int size = arr.length;
        Random r = new Random();
        int arr[] = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }
        HeapSort obj = new HeapSort();
        
        System.out.println("Orignal Array is: ");
        obj.display(arr);

        obj.sort(arr);
        System.out.println("\n \nSorted array is: ");
        obj.display(arr);
    }
}