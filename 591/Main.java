
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int id = 1;; id++) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }

            int[] set = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                set[i] = sc.nextInt();
                sum += set[i];
            }

            int avg = sum / n;
            int mov = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] > avg) {
                    mov += set[i] - avg;
                }
            }

            System.out.println("Set #" + id);
            System.out.println("The minimum number of moves is " + mov + ".");
            System.out.println();
        }
    }
}
