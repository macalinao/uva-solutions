
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double s = sc.nextInt();
            double v = sc.nextInt();

            double[][] ns = new double[n][2];
            for (int i = 0; i < n; i++) {
                ns[i][0] = sc.nextDouble();
                ns[i][1] = sc.nextDouble();
            }
            double[][] ms = new double[m][2];
            for (int i = 0; i < m; i++) {
                ms[i][0] = sc.nextDouble();
                ms[i][1] = sc.nextDouble();
            }

            Node start = new Node();
            Node end = new Node();

            Node[] mn = new Node[ms.length];
            for (int i = 0; i < mn.length; i++) {
                mn[i] = new Node();
                mn[i].c.add(end);
            }
            
            int[][] c = new int[n][m];

            double x2 = v * s * v * s;
            for (int i = 0; i < ns.length; i++) {
                for (int j = 0; j < ms.length; j++) {
                    double dsq = (ns[i][0] - ms[j][0]) * (ns[i][0] - ms[j][0])
                            + (ns[i][1] - ms[j][1]) * (ns[i][1] - ms[j][1]);
                    if (dsq <= x2) {
                        c[i][j] = 1;
                    }
                }
            }

            System.out.println(n - start.maxFlow(end));
        }
    }

    static class Node {

        List<Children> c = new ArrayList<>();

        public int maxFlow(Node o) {
            for(;;) {
                
            }
        }
    }
}