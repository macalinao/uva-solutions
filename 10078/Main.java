
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            List<Point> pt = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                pt.add(new Point(a, b));
            }
            Collections.sort(pt);
            if (convex(pt)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }
    }

    public static double ccw(Point a, Point b, Point c) {
        return (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
    }

    static boolean convex(List<Point> points) {
        int n = points.size();

        Collections.sort(points);
        final Point lowest = points.remove(0);
        Collections.sort(points, new Comparator<Point>() {

            public int compare(Point a, Point b) {
                return Double.valueOf(lowest.angle(a)).compareTo(lowest.angle(b));
            }
        });
        points.add(0, lowest);

        Stack<Point> stack = new Stack<Point>();
        stack.push(points.get(0));
        stack.push(points.get(1));
        for (int i = 2; i < points.size(); i++) {
            Point head = points.get(i);
            Point middle = stack.pop();
            Point tail = stack.peek();

            double ccw = ccw(tail, middle, head);

            if (ccw < 0) {
                stack.push(middle);
                stack.push(head);
            } else if (ccw > 0) {
                i--;
            } else {
                stack.push(head);
            }

        }

        // close the hull
        stack.push(points.get(0));

        return stack.size() - 1 != points.size();
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
            int c = Double.valueOf(y).compareTo(o.y);
            if (c == 0) {
                return Double.valueOf(x).compareTo(o.x);
            } else {
                return c;
            }
        }

        public double angle(Point o) {
            return Math.atan2(o.y - y, o.x - x);
        }
    }
}