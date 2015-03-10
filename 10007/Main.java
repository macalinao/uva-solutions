
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            System.out.println(trees(n));
        }
    }

    public static BigInteger factorial(int n) {
        BigInteger base = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            base = base.multiply(BigInteger.valueOf(i));
        }
        return base;
    }

    public static BigInteger trees(int n) {
        return factorial(2 * n).divide(factorial(n + 1));
    }
}
