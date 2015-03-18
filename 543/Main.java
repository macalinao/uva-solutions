
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        main:
        for (;;) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            for (int i = 3; i <= n / 2; i += 2) {
                if (isPrime[i] && isPrime[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    continue main;
                }
            }
            System.out.println("Goldbach's conjecture is wrong.");
        }
    }
    static final int N = 1000000;
    static boolean[] isPrime = new boolean[N + 1];

    static {

        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= N using Sieve of Eratosthenes
        for (int i = 2; i * i <= N; i++) {

            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[i]) {
                for (int j = i; i * j <= N; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primes++;
            }
        }
    }
}