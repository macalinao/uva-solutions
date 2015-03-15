
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] pts = sc.nextLine().split(" ");
            char[] a = pts[0].toCharArray();
            char[] b = pts[1].toCharArray();
            int i = 0;
            int j = 0;
            while (j < b.length && i < a.length) {
                if (a[i] == b[j]) {
                    i++;
                }
                j++;
            }
            System.out.println((i == a.length) ? "Yes" : "No");
        }
    }
}
