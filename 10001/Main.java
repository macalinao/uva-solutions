
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
        int[] rep = new int[len];
        Arrays.fill(rep, -1);

        for (int i = 0; i < len; i++) {
            // continue if it's already calculated
            if (rep[i] != -1) {
                continue;
            }

            int left = i - 1;
            if (left == -1) {
                left = len - 1;
            }
            int right = i + 1;
            if (right == len) {
                right = 0;
            }

            // Get current value of thing
            int curr = (state >> (len - i - 1)) & 1;
            int l = rep[left];
            int r = rep[right];

            boolean valid = false;
            boolean canZero = false;
            boolean canOne = false;
            boolean lCanZero = false;
            boolean lCanOne = false;
            boolean rCanZero = false;
            boolean rCanOne = false;

            // check all potential previous states and see if there is at least one
            if ((id & 1) == curr && ((l == 0 || l == -1) && (r == 0 || r == -1))) {
                valid = true;
                canZero = true;
                lCanZero = true;
                rCanZero = true;
            }
            if ((id >> 1 & 1) == curr && ((l == 0 || l == -1) && (r == 1 || r == -1))) {
                valid = true;
                canZero = true;
                lCanZero = true;
                rCanOne = true;
            }
            if ((id >> 2 & 1) == curr && ((l == 0 || l == -1) && (r == 0 || r == -1))) {
                valid = true;
                canOne = true;
                lCanZero = true;
                rCanZero = true;
            }
            if ((id >> 3 & 1) == curr && ((l == 0 || l == -1) && (r == 1 || r == -1))) {
                valid = true;
                canOne = true;
                lCanZero = true;
                rCanOne = true;
            }
            if ((id >> 4 & 1) == curr && ((l == 1 || l == -1) && (r == 0 || r == -1))) {
                valid = true;
                canZero = true;
                lCanZero = false;
                rCanZero = true;
            }
            if ((id >> 5 & 1) == curr && ((l == 1 || l == -1) && (r == 1 || r == -1))) {
                valid = true;
                canZero = true;
                lCanZero = false;
                rCanOne = true;
            }
            if ((id >> 6 & 1) == curr && ((l == 1 || l == -1) && (r == 0 || r == -1))) {
                valid = true;
                canOne = true;
                lCanZero = false;
                rCanZero = true;
            }
            if ((id >> 7 & 1) == curr && ((l == 1 || l == -1) && (r == 1 || r == -1))) {
                valid = true;
                canOne = true;
                lCanZero = false;
                rCanOne = true;
            }

            if (!valid) {
                return true;
            }

            System.out.println("ID: " + Integer.toBinaryString(id) + "; L: " + l + "; R: " + r + "; CURR: " + curr + "; " + canZero + " " + canOne);
            if (canZero && !canOne) {
                rep[i] = 0;
            } else if (!canZero && canOne) {
                rep[i] = 1;
            }

            if (lCanZero && !lCanOne) {
                rep[left] = 0;
            } else if (!lCanZero && lCanOne) {
                rep[left] = 1;
            }

            if (rCanZero && !rCanOne) {
                rep[right] = 0;
            } else if (!rCanZero && rCanOne) {
                rep[right] = 1;
            }
        }

        return true;
    }
}
