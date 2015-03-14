
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Case " + i + ": " + sum(a, b));
        }
    }

    static int sum(int a, int b) {
        int ret = 0;
        if (a % 2 == 0) {
            a++;
        }
        if (b % 2 == 0) {
            b--;
        }
        while (a <= b) {
            ret += a;
            a += 2;
        }
        return ret;
    }
}
