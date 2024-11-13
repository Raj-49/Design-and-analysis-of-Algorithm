import java.util.Scanner;

public class Practical_12_Chained_Matrix_Multiplication_Dynamic_Programming {
    public static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int q = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < dp[i][j]) {
                        dp[i][j] = q;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of matrices: ");
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        System.out.println("Enter the dimensions of the matrices (n+1 elements):");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }
        int minMultiplications = matrixChainOrder(p, n + 1);
        System.out.println("Minimum number of multiplications is: " + minMultiplications);
        sc.close();
    }
}
