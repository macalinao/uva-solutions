
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int n = 1500;

        // pointers to the last multiplied
        int last2 = 0;
        int last3 = 0;
        int last5 = 0;

        long[] result = new long[n];
        result[0] = 1;
        for (int i = 1; i < n; ++i) {
            long prev = result[i - 1];

            // Find next index to multiply
            while (result[last2] * 2 <= prev) {
                last2++;
            }
            while (result[last3] * 3 <= prev) {
                last3++;
            }
            while (result[last5] * 5 <= prev) {
                last5++;
            }

            // Determine which to multiply
            long candidate1 = result[last2] * 2;
            long candidate2 = result[last3] * 3;
            long candidate3 = result[last5] * 5;

            result[i] = Math.min(candidate1, Math.min(candidate2, candidate3));
        }

        System.out.println("The 1500'th ugly number is " + result[n - 1] + ".");

    }
}
