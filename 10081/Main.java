
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            dp = new double[n + 1][k + 1];

            double ct = 0;
            for (int i = 0; i <= k; i++) {
                ct += f(k, n, i);
            }
            ct *= 100;

            double max = Math.pow(k + 1, n);

            System.out.println(String.format("%.5f", (double) ct / max));

        }
    }

    static double[][] dp;

    static double f(int k, int n, int s) {
        if (n == 1) {
            return 1;
        }

        if (dp[n][s] != 0) {
            return dp[n][s];
        }

        double sum = 0;
        if (s > 0) {
            sum += f(k, n - 1, s - 1);
        }
        sum += f(k, n - 1, s);
        if (s < k) {
            sum += f(k, n - 1, s + 1);
        }

        dp[n][s] = sum;
        return sum;
    }
}
