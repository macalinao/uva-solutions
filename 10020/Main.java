
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
                int res = Integer.valueOf(t.a).compareTo(t1.a);
                if (res == 0) {
                    return Integer.valueOf(t.b).compareTo(t1.b);
                } else {
                    return res;
                }
            }
        });

        List<C> best = best(M, cs);

        if (!best.isEmpty()) {
            String r = best.size() + "\n";
            for (C c : best) {
                r += c.toString() + "\n";
            }
            return r.substring(0, r.length() - 1);
        } else {
            return "0";
        }
    }

    static LinkedList<C> best(int m, List<C> cs) {
        LinkedList<C> best = new LinkedList<>();
        C base = null;
        int min = 0;
        for (int i = 0; i < cs.size(); i++) {
            C c = cs.get(i);
            if (base == null) {
                if (c.a <= min) {
                    base = c;
                }
                continue;
            } else {
                if (base.b >= m) {
                    break;
                }
            }
            if (c.a > min) {
                min = base.b;
                if (c.a > min) {
                    break;
                }
                best.add(base);
                base = c;
                continue;
            }
            if (c.b > base.b) {
                base = c;
            }
        }
        if (base != null) {
            best.add(base);
        }
        if (best.peekLast() != null && best.peekLast().b < m) {
            best.clear();
        }
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
