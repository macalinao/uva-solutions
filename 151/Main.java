
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        main:
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            for (int i = 1;; i++) {
                if (j(n, i) == 13) {
                    System.out.println(i);
                    continue main;
                }
            }
        }
    }

    static int j(int n, int m) {
        List<Integer> l = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            l.add(i);
        }

        int r = 0;
        for (;;) {
            while (r < l.size()) {
                l.remove(r);
                if (l.size() == 1) return l.get(0);
                r += m - 1;
            }
            r %= l.size();
        }
    }
}