
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("PERFECTION OUTPUT");
        for (;;) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            int divsum = 1;
            int sqrt = (int) Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    divsum += i + (n / i);
                }
            }
            if (sqrt * sqrt == n) {
                divsum -= sqrt;
            }

            String type = null;
            if (divsum < n) {
                type = "DEFICIENT";
            } else if (divsum == n) {
                type = "PERFECT";
            } else if (divsum > n) {
                type = "ABUNDANT";
            }
            System.out.println(String.format("%5d  " + type, n));
        }
        System.out.println("END OF OUTPUT");
    }
}
