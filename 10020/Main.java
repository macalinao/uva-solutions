
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int asdf = sc.nextInt();
        while (asdf-- > 0) {
            int M = sc.nextInt();
            List<C> cs = new ArrayList<>();

            for (;;) {
                int i = sc.nextInt();
                int j = sc.nextInt();
                if (i == 0 && j == 0) {
                    break;
                }
                // check if applicable
                if ((i < 0 || i > M) && (j < 0 || j > M)) {
                    continue;
                }
                cs.add(new C(i, j));
            }

            System.out.println(solve(M, cs));

            if (asdf != 0) {
                System.out.println();
            }
        }
    }

    public static String solve(int M, List<C> cs) {
        Collections.sort(cs, new Comparator<C>() {

            public int compare(C t, C t1) {
                return Integer.valueOf(t.a).compareTo(t1.a);
            }
        });

        bests = new LinkedList[5001][5001];
        List<C> best = best(0, M, cs, 0);

        if (best != null) {
            String r = best.size() + "\n";
            for (C c : best) {
                r += c.toString() + "\n";
            }
            return r.substring(0, r.length() - 1);
        } else {
            return "0";
        }
    }
    static LinkedList<C>[][] bests;

    static LinkedList<C> best(int min, int max, List<C> cs, int start) {
        LinkedList<C> best = bests[min][max];
        if (best != null) {
            return best;
        }

        // find best
        for (int i = start; i < cs.size(); i++) {
            C c = cs.get(i);
            if (c.a > min) {
                break;
            }
            if (c.b >= max) {
                best = new LinkedList<C>();
                best.add(c);
                break;
            }
            LinkedList<C> b = best(c.b, max, cs, i + 1);
            if (b == null) {
                continue;
            }
            if (best == null || b.size() + 1 < best.size()) {
                best = b;
                best.addFirst(c);
            }
        }

        bests[min][max] = best;
        return best;
    }

    static class C {

        int a;
        int b;

        public C(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }
}
