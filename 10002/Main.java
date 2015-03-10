
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int ct = sc.nextInt();
            if (ct < 3) {
                break;
            }
            List<Point> pts = new ArrayList<>();
            for (int i = 0; i < ct; i++) {
                pts.add(new Point(sc.nextDouble(), sc.nextDouble()));
            }
            System.out.println(centerOfMass(convexHull(pts)));
        }
    }

    public static double ccw(Point a, Point b, Point c) {
        return (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
    }

    public static List<Point> convexHull(List<Point> pts) {
        int n = pts.size(), k = 0;
        List<Point> h = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            h.add(new Point(0, 0));
        }
        Collections.sort(pts);
        for (int i = 0; i < n; i++) {
            while (k >= 2 && ccw(h.get(k - 2), h.get(k - 1), pts.get(i)) <= 0) {
                k--;
            }
            h.set(k++, pts.get(i));
        }
        for (int i = n - 2, t = k + 1; i >= 0; i--) {
            while (k >= t && ccw(h.get(k - 2), h.get(k - 1), pts.get(i)) <= 0) {
                k--;
            }
            h.set(k++, pts.get(i));
        }
        h = h.subList(0, k - 1);
        return h;
    }

    public static Point centerOfMass(List<Point> pts) {
        double xt = 0;
        double yt = 0;
        double at = 0;
        for (int i = 0; i < pts.size(); i++) {
            Point p = pts.get(i);
            Point p2 = pts.get((i + 1) % pts.size());
            double xi = p.x;
            double xi1 = p2.x;
            double yi = p.y;
            double yi1 = p2.y;

            double aa = xi * yi1 - xi1 * yi;
            xt += (xi + xi1) * aa;
            yt += (yi + yi1) * aa;
            at += aa;
        }

        at /= 2.0;
        double factor = 1 / (6 * at);
        xt *= factor;
        yt *= factor;

        return new Point(xt, yt);
    }

    public static class Point implements Comparable<Point> {

        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%.3f", x) + " " + String.format("%.3f", y);
        }

        @Override
        public int compareTo(Point o) {
            if (o.x < x) {
                return 1;
            } else if (o.x == x) {
                if (o.y < y) {
                    return 1;
                } else if (o.y == y) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }

        public double angle(Point o) {
            return Math.atan2(o.y - y, o.x - x);
        }
    }

}
