
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fn = 1;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) {
                return;
            } else if (fn != 1) {
                System.out.println();
            }

            sc.nextLine();

            char[][] arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLine().toCharArray();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char c = arr[i][j];
                    if (c == '*') {
                        continue;
                    }

                    arr[i][j] = Integer.valueOf(
                            ((i > 0 && j > 0) ? (arr[i - 1][j - 1] == '*' ? 1 : 0) : 0)
                            + ((i < n - 1 && j > 0) ? (arr[i + 1][j - 1] == '*' ? 1 : 0) : 0)
                            + ((i > 0 && j < m - 1) ? (arr[i - 1][j + 1] == '*' ? 1 : 0) : 0)
                            + ((i < n - 1 && j < m - 1) ? (arr[i + 1][j + 1] == '*' ? 1 : 0) : 0)
                            + ((i > 0) ? (arr[i - 1][j] == '*' ? 1 : 0) : 0)
                            + ((j > 0) ? (arr[i][j - 1] == '*' ? 1 : 0) : 0)
                            + ((i < n - 1) ? (arr[i + 1][j] == '*' ? 1 : 0) : 0)
                            + ((j < m - 1) ? (arr[i][j + 1] == '*' ? 1 : 0) : 0)
                    ).toString().charAt(0);
                }
            }

            System.out.println("Field #" + fn++ + ":");
            for (char[] ca : arr) {
                System.out.println(String.valueOf(ca));
            }
        }
    }
}
