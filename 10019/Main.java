
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();

            int b1 = 0;
            for (int j = 0; j < Integer.SIZE; j++) {
                if (((N >> j) & 1) == 1) {
                    b1++;
                }
            }

            int Nh = Integer.parseInt(Integer.toString(N), 16);
            int b2 = 0;
            for (int j = 0; j < Integer.SIZE; j++) {
                if (((Nh >> j) & 1) == 1) {
                    b2++;
                }
            }

            System.out.println(b1 + " " + b2);
        }
    }
}
