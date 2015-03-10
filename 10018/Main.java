import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      long a = sc.nextInt();
      for (int x = 0;;x++) {
        long b = reverse(a);
        if (a == b) {
          System.out.println(x + " " + a);
          break;
        }
        a += b;
      }
    }
  }

  /**
   * Reverses a number.
   */
  public static long reverse(long num) {
    return Long.parseLong(new StringBuilder(Long.toString(num)).reverse().toString());
  }
}
