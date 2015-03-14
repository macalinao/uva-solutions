
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int a = sc.nextInt();
            int f = sc.nextInt();

            for (int i = 0; i < f; i++) {
                print(a);
                if (i != f - 1) {
                    System.out.println();
                }
            }

            if (T != 0) {
                System.out.println();
            }
        }
    }

    static void print(int a) {
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= a; i++) {
            for (int j = 0; j < i; j++) {
                s.append(i);
            }
            s.append("\n");
        }
        for (int i = a - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                s.append(i);
            }
            s.append("\n");
        }
        System.out.print(s);
    }
}
