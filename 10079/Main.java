
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextInt();
            if (n < 0) {
                return;
            }
            System.out.println((n * n + n + 2) / 2);
        }
    }
}
