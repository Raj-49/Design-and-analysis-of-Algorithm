import java.util.Arrays;
import java.util.Scanner;

public class Practical_9_Making_Change_Dynamic_Programming {
    public static int minCoins(int[] coins, int n, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int subResult = dp[i - coins[j]];
                    if (subResult != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], subResult + 1);
                    }
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of coin denominations: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the coin denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print("Enter the amount to make change for: ");
        int amount = sc.nextInt();
        int result = minCoins(coins, n, amount);
        if (result == -1) {
            System.out.println("Change cannot be made with the given coins.");
        } else {
            System.out.println("Minimum number of coins required: " + result);
        }
        sc.close();
    }
}
