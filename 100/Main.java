
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            int max = 0;
            for (int x = i; x <= j; x++) {
                max = Math.max(max, cycleLen(x));
            }
            System.out.println(i + " " + j + " " + max);
        }
    }
    
    public static int cycleLen(int n) {
        int len = 1;
        while (n != 1) {
            if (n % 2 != 0) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            len++;
        }
        return len;
    }
}
