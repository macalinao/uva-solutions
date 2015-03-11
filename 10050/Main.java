
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            boolean[] r = new boolean[sc.nextInt()];
            int p = sc.nextInt();
            for (int i = 0; i < p; i++) {
                int s = sc.nextInt();
                for (int x = s - 1; x < r.length; x += s) {
                    r[x] = true;
                }
            }
            int sum = 0;
            for (int i = 0; i < r.length; i += 7) {
                for (int j = 0; j <= 4; j++) {
                    int ix = i + j;
                    if (ix >= r.length) {
                        break;
                    }
                    sum += (r[ix] ? 1 : 0);
                }
            }
            System.out.println(sum);
        }
    }
}