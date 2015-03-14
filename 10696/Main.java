
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        for (;;) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            s.append("f91(").append(n).append(") = ").append(f91(n)).append("\n");
        }
        System.out.print(s);
    }

    static int f91(int n) {
        return (n <= 100) ? 91 : n - 10;
    }
}
