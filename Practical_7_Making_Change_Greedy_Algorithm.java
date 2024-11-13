import java.util.Scanner;

public class Practical_7_Making_Change_Greedy_Algorithm {

    public static void makeChange(int[] coins, int n, int amount) {
        int count = 0;
        for (int i = 0; i < n; i++) {

            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
                System.out.println("Used a coin of " + coins[i]);
            }
        }
        if (amount == 0) {
            System.out.println("Total number of coins used: " + count);
        } else {

            System.out.println("Change cannot be made with the given coins.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] coins = { 20, 10, 5, 2, 1 };
        int n = coins.length;

        System.out.print("Enter the amount to make change for: ");
        int amount = sc.nextInt();

        System.out.println("Coins used to make change:");
        makeChange(coins, n, amount);

        sc.close();
    }
}
