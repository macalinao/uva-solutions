import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            double n = sc.nextInt();
            n = ((((n * 567) / 9) + 7492) * 235) / 47 - 498;
            n /= 10;
            System.out.println(Math.abs(((int) n) % 10));
        }
    }
}