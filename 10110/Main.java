
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            long n = sc.nextLong();
            if (n == 0) {
                return;
            }
            System.out.println(isOn(n) ? "yes" : "no");
        }
    }

    static boolean isOn(long n) {
        long sqrt = (long) Math.sqrt(n);
        return (sqrt * sqrt == n);
    }
}
