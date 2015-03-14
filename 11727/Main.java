
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            List<Integer> l = new LinkedList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            Collections.sort(l);
            l.remove(0);
            l.remove(1);

            System.out.println("Case " + i + ": " + l.get(0));
        }
    }
}
