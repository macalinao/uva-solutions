
import java.util.*;

public class Main {

    static Map<Integer, Node> nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        main:
        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (num == 0) {
                return;
            }
            int l = sc.nextInt();
            nodes = new HashMap<>();

            Node a = null;
            for (int i = 0; i < l; i++) {
                a = getNode(sc.nextInt());
                Node b = getNode(sc.nextInt());
                a.c.add(b);
                b.c.add(a);
            }

            // bfs
            LinkedList<Node> q = new LinkedList<>();
            q.add(a);
            a.s = 0;
            while (!q.isEmpty()) {
                Node d = q.poll();
                for (Node n : d.c) {
                    if (n.s == -1) {
                        n.s = d.s == 0 ? 1 : 0;
                        q.add(n);
                    } else if (n.s == d.s) {
                        System.out.println("NOT BICOLORABLE.");
                        continue main;
                    }
                }
            }
            System.out.println("BICOLORABLE.");
        }
    }

    public static Node getNode(int x) {
        Node r = nodes.get(x);
        if (r == null) {
            r = new Node();
            nodes.put(x, r);
        }
        return r;
    }

    public static class Node {

        List<Node> c = new ArrayList<>();
        int s = -1;
    }
}
