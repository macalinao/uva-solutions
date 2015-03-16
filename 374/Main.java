
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int b = sc.nextInt();
            int p = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(modPow(b, p, m));
        }
    }

    public static int modPow(long a, long b, long n) {
        long r = 1;
        for (;;) {
            if (b % 2 == 1) {
                r = (r * a) % n;
            }
            b /= 2;
            if (b == 0) {
                break;
            }
            a = (a * a) % n;
        }
        return (int) r;
    }
}
