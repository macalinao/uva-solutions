
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (;;) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int lp = 0;
            int lq = 1;
            int p = 1;
            int q = 1;
            int rp = 1;
            int rq = 0;

            if (a == 1 && b == 1) {
                break;
            }

            String ret = "";
            while (!(a == p && b == q)) {
                if ((double) a / (double) b > (double) p / (double) q) {
                    // right
                    lp = p;
                    lq = q;
                    p += rp;
                    q += rq;
                    ret += "R";
                } else {
                    // left
                    rp = p;
                    rq = q;
                    p += lp;
                    q += lq;
                    ret += "L";
                }
            }
            System.out.println(ret);

        }
    }
}