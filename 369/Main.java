
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                return;
            }
            System.out.println(a + " things taken " + b + " at a time is " + choose(a, b) + " exactly.");
        }
    }

    static BigInteger choose(int n, int k) {
        return fact(n).divide(fact(k).multiply(fact(n - k)));
    }

    static BigInteger fact(long n) {
        BigInteger prod = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            prod = prod.multiply(BigInteger.valueOf(i));
        }
        return prod;
    }
}
