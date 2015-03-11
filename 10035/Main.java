
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            if (a == 0 && b == 0) {
                return;
            }

            int carries = 0;
            int carry = 0;

            long x = Math.max(a, b);
            long y = Math.min(a, b);
            while (x > 0) {
                int s = (int) (x % 10 + y % 10 + carry);
                carry = 0;
                if (s >= 10) {
                    carry = (int) (s / 10);
                    carries += carry;
                }

                x /= 10;
                y /= 10;
            }

            if (carries > 1) {
                System.out.println(carries + " carry operations.");
            } else if (carries == 1) {
                System.out.println("1 carry operation.");
            } else {
                System.out.println("No carry operation.");
            }
        }
    }
}