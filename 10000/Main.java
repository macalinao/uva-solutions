
import java.util.*;

public class Main {

    private static Map<Integer, Node> nodes = new HashMap<>();

    public static void main(String[] args) {
        int c = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            int s = sc.nextInt();

            // Construct graph
            for (;;) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (a == 0 && b == 0) {
                    break;
                }

                Node an = get(a);
                Node bn = get(b);
                an.to.add(bn);
            }

            solve(++c, n, s);

            nodes = new HashMap<>();
            sc.nextLine();
        }
    }

    public static Node get(int n) {
        Node ret = nodes.get(n);
        if (ret == null) {
            ret = new Node(n);
            nodes.put(n, ret);
        }
        return ret;
    }

    public static void solve(int c, int n, int s) {
        Node sn = get(s);
        Ret sol = sn.longestPath();
        System.out.println("Case " + c + ": The longest path from " + s + " has length " + sol.length + ", finishing at " + sol.terminus + ".\n");
    }

    public static class Node {

        public int val;

        public Ret longest = null;

        public Set<Node> to = new HashSet<>();

        public Node(int val) {
            this.val = val;
        }

        public Ret longestPath() {
            if (to.isEmpty()) {
                return new Ret(0, val);
            }

            if (longest != null) {
                return longest;
            }

            Ret r = new Ret(-1, -1);
            for (Node n : to) {
                Ret nr = n.longestPath();
                if (nr.length >= r.length) {
                    if (nr.length == r.length) {
                        if (nr.terminus < r.terminus) {
                            r = nr;
                        }
                    } else {
                        r = nr;
                    }
                }
            }

            Ret rt = new Ret(r.length + 1, r.terminus);
            longest = rt;
            return rt;
        }
    }

    public static class Ret {

        public int length;
        public int terminus;

        public Ret(int length, int terminus) {
            this.length = length;
            this.terminus = terminus;
        }

    }

}
