
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0) {
            int n = sc.nextInt();
            int sum = 0;
            int[] g = new int[n];
            for (int i = 0; i < n; i++) {
                g[i] = sc.nextInt();
                sum += g[i];
            }

            double avg = sum / (double) n;
            int aa = 0;
            for (int i : g) {
                if (i > avg) {
                    aa++;
                }
            }
            System.out.println(String.format("%.3f", aa * 100 / (double) n) + "%");
        }
    }
}
