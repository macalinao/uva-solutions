
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // calculate sums from i-th row to j-th row
        int[][][] sums = new int[n + 1][n + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    sums[i][j][k] = sums[i][j - 1][k] + arr[j - 1][k - 1];
                }
                max = Math.max(max, maxSum(sums[i][j]));
            }
        }
        System.out.println(max);
    }

    static int maxSum(int[] arr) {
        // Kadane's.
        int a = 0, b = 0;
        for (int i : arr) {
            a = Math.max(0, a + i);
            b = Math.max(a, b);
        }
        return b;
    }
}
