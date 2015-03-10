import java.util.*;

public class Main {
  static Map<Character, Node> nodes;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();

    for (int i = 0; i < c; i++) {
      nodes = new HashMap<>();
      int a = sc.nextInt();
      int b = sc.nextInt();

      Node n1, n2;

      sc.nextLine();
      for (int x = 0; x < a; x++) {
        String[] l = sc.nextLine().split(" ");
        n1 = get(l[0].charAt(0));
        n2 = get(l[1].charAt(0));
        n1.c.add(n2);
        n2.c.add(n1);
      }

      // pairs
      for (int x = 0; x < b; x++) {
        String[] l = sc.nextLine().split(" ");
        System.out.println(get(l[0].charAt(0)).sp(get(l[1].charAt(0)), new HashSet<Node>()));
      }
      if (i != c - 1) System.out.println();
    }
  }

  static Node get(char n) {
    Node r = nodes.get(n);
    if (r == null) {
      r = new Node(n);
      nodes.put(n, r);
    }
    return r;
  }

  static class Node {
    char n;
    List<Node> c = new ArrayList<>();

    public Node(char n) {
      this.n = n;
    }

    String sp(Node b, Set<Node> v) {
      if (this == b) return "" + n;

      v.add(this);

      String sp = null;
      for (Node n : c) {
        if (v.contains(n)) continue;

        String t = n.sp(b, v);
        if (sp == null) {
          sp = t;
          continue;
        }

        if (t != null && t.length() < sp.length()) {
          sp = t;
        }
      }

      if (sp == null) return sp;
      return n + "" + sp;
    }
  }
}
