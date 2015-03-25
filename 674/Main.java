
import java.util.*;

public class Main {

    static int[] c = {50, 25, 10, 5, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(f(n, 0));
        }
    }

    static int f(int n, int i) {
        if (i == c.length - 1) {
            return 1;
        }

        int s = 0;
        for (int ct = 0; ct * c[i] <= n; ct++) {
            s += f(n - ct * c[i], i + 1);
        }
        return s;
    }

}
