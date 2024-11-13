import java.util.Arrays;
import java.util.Scanner;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double getRatio() {
        return (double) value / weight;
    }
}

public class Practical_8_knapsack_Greedy_Algorithm {
    public static double knapsackGreedy(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.getRatio(), a.getRatio()));
        double totalValue = 0;
        int currentWeight = 0;
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
                System.out.println("Added full item with weight " + item.weight + " and value " + item.value);
            } else {
                int remainingCapacity = capacity - currentWeight;
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                currentWeight += remainingCapacity;
                System.out.println("Added " + (fraction * 100) + "% of item with weight " + item.weight
                        + " and value " + item.value);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }
        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = sc.nextInt();
        double maxValue = knapsackGreedy(items, capacity);
        System.out.println("Maximum value in the knapsack: " + maxValue);

        sc.close();
    }
}
