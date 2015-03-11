import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int M = sc.nextInt();
    while (M-- > 0) {
      int N = sc.nextInt();
      int[][] s = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          s[i][j] = sc.nextInt();
        }
      }

      sc.nextLine();

      // calc rings
      int rings = N / 2;
      if (N % 2 != 0) rings++;

      for (int i = 0; i < rings; i++) {
        String[] op = sc.nextLine().split(" ");
        op[0] = "5";

        for (String o : op) {
          switch (o) {
            case "1":
              flip(i, s, false);
              break;
            case "2":
              flip(i, s, true);
              break;
            case "3":
              flip(i, s, true);
              ccw(i, s);
              break;
            case "4":
              flip(i, s, false);
              ccw(i, s);
              break;
          }
        }
      }

      for (int i = 0; i < s.length; i++) {
        String p = "";
        for (int j = 0; j < s.length; j++) {
          p += s[i][j] + " ";
        }
        System.out.println(p.trim());
      }

    }
  }

  public static void flip(int r, int[][] s, boolean lr) {
    // top/bottom
    int min = r;
    int max = s.length - r - 1;
    if (min == max) return;
    for (int i = min; i <= max; i++) {
      if (lr) {
        int tmp = s[i][min];
        s[i][min] = s[i][max];
        s[i][max] = tmp;
      } else {
        int tmp = s[min][i];
        s[min][i] = s[max][i];
        s[max][i] = tmp;
      }
    }

    // sides
    for (int i = min + 1, x = max / 2; i <= x; i++) {
      if (lr) {
        int tmp = s[min][i];
        s[min][i] = s[min][max - i];
        s[min][max - i] = tmp;
        tmp = s[max][i];
        s[max][i] = s[max][max - i];
        s[max][max - i] = tmp;
      } else {
        int tmp = s[i][min];
        s[i][min] = s[max - i][min];
        s[max - i][min] = tmp;
        tmp = s[i][max];
        s[i][max] = s[max - i][max];
        s[max - i][max] = tmp;
      }
    }

  }

  public static void ccw(int r, int[][] s) {
    int min = r;
    int max = s.length - r - 1;
    int n = s.length - 1;
    if (min == max) return;
    for (int i = min; i < max; i++) {
      int tmp = s[i][max];
      s[i][max] = s[max][n - i];
      s[max][n - i] = s[n - i][min];
      s[n - i][min] = s[min][i];
      s[min][i] = tmp;
    }
  }
}
