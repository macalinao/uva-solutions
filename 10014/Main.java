import java.util.*;

public class Main {
  static int n;
  static double a0;
  static double an1;
  static double[] c;
  static double[] mem;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int asdf = sc.nextInt();
    while (asdf-- > 0) {
      n = sc.nextInt();
      a0 = sc.nextDouble();
      an1 = sc.nextDouble();
      c = new double[n];
      mem = new double[n + 1];
      for (int i = 0; i < c.length; i++) {
        c[i] = sc.nextDouble();
      }
      double s = a0 * n + an1;
      for (int i = n; i >= 1; i--) {
        s -= 2 * (n - i + 1) * c[i - 1];
      }
      System.out.println(String.format("%.2f", s / (n + 1)));
      if (asdf != 0) System.out.println();
    }
  }
}
