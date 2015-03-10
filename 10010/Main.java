import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int c = sc.nextInt();
    for (int i = 0; i < c; i++) {

      int m = sc.nextInt();
      int n = sc.nextInt();
      sc.nextLine();

      char[][] grid = new char[m][n];
      for (int x = 0; x < m; x++) {
        grid[x] = sc.nextLine().toUpperCase().toCharArray();
      }

      int ct = sc.nextInt();
      sc.nextLine();
      String[] search = new String[ct];
      for (int x = 0; x < ct; x++) {
        search[x] = sc.nextLine().toUpperCase();
      }
      System.out.println(find(grid, search));

      if (c - 1 != i) {
        System.out.println();
      }
    }
  }

  public static boolean check(char[][] grid, int x, int y, String w, int u, int d, int l, int r) {
    // check
    int len = w.length();

    boolean[][] trip = new boolean[][] {
      {len <= u && len <= l, len <= u, len <= u && len <= r},
      {len <= l, false, len <= r},
      {len <= d && len <= l, len <= d, len <= d && len <= r}
    };

    char[] a = w.toCharArray();
    // check it all
    for (int i = 0; i < len; i++) {
      if (len <= u) {
        if (len <= l) {
          if (grid[y - i][x - i] != a[i]) trip[0][0] = false;
        }
        if (grid[y - i][x] != a[i]) trip[0][1] = false;
        if (len <= r) {
          if (grid[y - i][x + i] != a[i]) trip[0][2] = false;
        }
      }
      if (len <= l) {
        if (grid[y][x - i] != a[i]) trip[1][0] = false;
      }
      if (len <= r) {
        if (grid[y][x + i] != a[i]) trip[1][2] = false;
      }
      if (len <= d) {
        if (len <= l) {
          if (grid[y + i][x - i] != a[i]) trip[2][0] = false;
        }
        if (grid[y + i][x] != a[i]) trip[2][1] = false;
        if (len <= r) {
          if (grid[y + i][x + i] != a[i]) trip[2][2] = false;
        }
      }
    }

    for (int i = 0; i <= 2; i++) {
      for (int j = 0; j <= 2; j++) {
        if (trip[i][j]) return true;
      }
    }
    return false;
  }

  public static String find(char[][] grid, String[] search) {
    String[] ret = new String[search.length];
    // rows
    for (int i = 0; i < grid.length; i++) {
      // cols
      for (int j = 0; j < grid[0].length; j++) {

        // find
        int u = i + 1;
        int d = grid.length - i;
        int l = j + 1;
        int r = grid[0].length - j;
        for (int x = 0; x < search.length; x++) {
          String w = search[x];
          if (w == null) continue;
          if (check(grid, j, i, w, u, d, l, r)) {
            ret[x] = (i + 1) + " " + (j + 1);
            search[x] = null;
          }
        }

      }
    }

    String p = "";
    for (String s : ret) {
      p += s + "\n";
    }
    p = p.substring(0, p.length() - 1);
    return p;
  }
}
