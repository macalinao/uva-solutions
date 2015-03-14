
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] pts = sc.nextLine().split(":");
            int h = Integer.parseInt(pts[0]);
            int m = Integer.parseInt(pts[1]);
            if (h == 0 && m == 0) {
                return;
            }
            double ang = Math.abs(
                    ((h % 12) * 360.0 / 12.0 + (m % 60) * 360.0 / 60.0 / 12.0)
                    - (m % 60) * 360.0 / 60.0);
            if (ang > 180) {
                ang = 360 - ang;
            }
            System.out.println(String.format("%.3f", ang));
        }
    }
}
