
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a:
        while (sc.hasNext()) {
            int n = sc.nextInt();
            boolean[] vis = new boolean[n - 1];

            int p = sc.nextInt();
            for (int i = 1; i < n; i++) {
                int q = sc.nextInt();
                int d = Math.abs(p - q);
                if (d >= 1 && d <= n - 1) {
                    vis[d - 1] = true;
                }
                p = q;
            }

            sc.nextLine();
            for (boolean b : vis) {
                if (!b) {
                    System.out.println("Not jolly");
                    continue a;
                }
            }
            System.out.println("Jolly");
        }
    }
}