
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            if (isCarmichael(n)) {
                System.out.println("The number " + n + " is a Carmichael number.");
            } else {
                System.out.println(n + " is normal.");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        if (n == 1 || n % 2 == 0) {
            return false;
        }
        int sq = (int) Math.sqrt(n);
        for (int i = 3; i <= sq; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // a ^ b % n
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

    public static boolean isCarmichael(int n) {
        if (isPrime(n)) {
            return false;
        }

        // check fermat prime
        for (int i = 2; i < n; i++) {
            if (modPow(i, n, n) != i) {
                return false;
            }
        }

        return true;
    }
}
