
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int id = sc.nextInt();
            int len = sc.nextInt();
            int state = sc.nextInt(2);
            System.out.println(isGOE(id, len, state) ? "GARDEN OF EDEN" : "REACHABLE");
        }
    }

    public static boolean isGOE(int id, int len, int state) {

        return true;
    }

    public static int nextState(int id, int len, int state) {
        int tmp = state;
        for (int i = 0; i < len; i++) {
            int left = i == 0 ? len - 1 : i - 1;
            int right = i == len - 1 ? 0 : i + 1;
        }
    }
}
