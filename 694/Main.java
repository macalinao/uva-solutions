import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1;;i++) {
            int a = sc.nextInt();
            int l =  sc.nextInt();
            if (a == -1 && l == -1) return;
            System.out.println("Case " + i + ": A = " + a + ", limit = " + l + ", number of terms = " + collatz(a, l));
        }
    }
    
    static int collatz(long n, int l) {
        if (n > l) return 0;
        if (n == 1) return 1;
        if (n % 2 == 0) {
            return collatz(n / 2, l) + 1;
        } else {
            return collatz(3 * n + 1, l) + 1;
        }
    }
}