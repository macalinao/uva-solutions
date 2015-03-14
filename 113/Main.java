
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double p = sc.nextDouble();
            System.out.println(Math.round(Math.pow(p, 1.0 / n)));
        }
    }
}
