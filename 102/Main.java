
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] c = new int[][]{
                {sc.nextInt(), sc.nextInt(), sc.nextInt()},
                {sc.nextInt(), sc.nextInt(), sc.nextInt()},
                {sc.nextInt(), sc.nextInt(), sc.nextInt()}
            };
            char[] cs = new char[]{'B', 'G', 'C'};

            int min = Integer.MAX_VALUE;
            String ret = null;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < 3; k++) {
                        if (k == i || k == j) {
                            continue;
                        }

                        int count = 0;
                        for (int x = 0; x < 3; x++) {
                            if (x != i) {
                                count += c[0][x];
                            }
                            if (x != j) {
                                count += c[1][x];
                            }
                            if (x != k) {
                                count += c[2][x];
                            }
                        }

                        if (count <= min) {
                            String s = "" + cs[i] + cs[j] + cs[k];
                            if (count == min ? (ret == null || s.compareTo(ret) < 0) : true) {
                                ret = s;
                                min = count;
                            }
                        }

                    }
                }
            }

            ret += " " + min;
            System.out.println(ret);
        }
    }
}
