import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      int ct = sc.nextInt();
      if (ct < 3) break;
      List<Point> pts = new ArrayList<>();
      for (int i = 0; i < ct; i++) {
        pts.add(new Point(sc.nextDouble(), sc.nextDouble()));
      }
      System.out.println(centerOfMass(convexHull(pts)));
    }
  }

  public static boolean ccw(Point a, Point b, Point c) {
    return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x) < 0;
  }

  public static List<Point> convexHull(List<Point> pts) {
    int n = pts.size();
    if (n < 3) return pts;
    int[] next = new int[n];
    Arrays.fill(next, -1);

    // leftmost
    int leftMost = 0;
    for (int i = 1; i < n; i++) {
      if (pts.get(i).x < pts.get(leftMost).x) leftMost = i;
    }
    int p = leftMost;

    do {
      int q = (p + 1) % n;
      for (int i = 0; i < n; i++) {
        if (ccw(pts.get(p), pts.get(i), pts.get(q))) q = i;
      }

      next[p] = q;
      p = q;
    } while (p != leftMost);

    List<Point> ret = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      ret.add(pts.get(i));
    }
    return ret;
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

    at = Math.abs(at / 2.0);
    double factor = 1 / (6 * at);
    xt *= factor;
    yt *= factor;

    return new Point(xt, yt);
  }

  public static class Point {
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
  }

}
