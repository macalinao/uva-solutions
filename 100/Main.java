
import java.util.*;

public class Main {

    static int[] dp = new int[10000000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            int max = 0;
            for (int x = Math.min(i, j); x <= Math.max(i, j); x++) {
                max = Math.max(max, cycleLen(x));
            }
            System.out.println(i + " " + j + " " + max);
        }
    }

    public static int cycleLen(int n) {
        if (n < dp.length && dp[n] != 0) {
            return dp[n];
        }

        if (n == 1) {
            return 1;
        }

        int len;
        if (n % 2 != 0) {
            len = cycleLen(3 * n + 1) + 1;
        } else {
            len = cycleLen(n / 2) + 1;
        }

        if (n < dp.length) {
            dp[n] = len;
        }
        return len;
    }
}
