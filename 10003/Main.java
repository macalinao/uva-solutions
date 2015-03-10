
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int l = sc.nextInt();
            if (l == 0) {
                break;
            }
            int n = sc.nextInt();
            int[] lens = new int[n + 2];
            lens[0] = 0;
            lens[lens.length - 1] = l;
            for (int i = 0; i < n; i++) {
                lens[i + 1] = sc.nextInt();
            }
            solve(l, n, lens);
        }
    }

    public static void solve(int l, int n, int[] lens) {
        mem = new int[52 * 52];
        System.out.println("The minimum cutting is " + s(lens, 0, lens.length - 1) + ".");
    }

    static int[] mem;

    public static int s(int[] lens, int min, int max) {
        if (max - min == 1) {
            return 0;
        }
        int ret = mem[min * 52 + max];
        if (ret != 0) {
            return ret;
        }

        // calculate minimum
        ret = Integer.MAX_VALUE;
        for (int i = min + 1; i < max; i++) {
            ret = Math.min(ret, s(lens, min, i) + s(lens, i, max));
        }
        ret += lens[max] - lens[min];
        mem[min * 52 + max] = ret;

        return ret;
    }

}
