
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int ct = 0;
            int b = 0;
            while (n > 0) {
                ct += n;
                b += n;
                n = b / k;
                b = b % k;
            }

            System.out.println(ct);
        }
    }
}
