
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }

            BigInteger b = BigInteger.valueOf(n);
            for (int i = n - 1; i >= 2; i--) {
                b = b.multiply(BigInteger.valueOf(i));
            }

            System.out.print(String.format("%3d", n) + "! =");
            int num = 0;
            for (int i = 2; !b.equals(BigInteger.ONE); i++) {
                if (!isPrime(i)) {
                    continue;
                }
                if (num++ % 15 == 0 && num >= 15) {
                    System.out.println();
                    System.out.print("      ");
                }
                int ct = 0;
                while (b.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                    b = b.divide(BigInteger.valueOf(i));
                    ct++;
                }
                System.out.print(String.format("%3d", ct));
            }

            System.out.println();
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
