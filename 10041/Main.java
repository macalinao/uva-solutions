
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int r = sc.nextInt();

            int[] arr = new int[r];
            for (int i = 0; i < r; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            int mi = arr.length / 2;
            int med = arr[mi];

            int sums = 0;
            for (int a : arr) {
                sums += Math.abs(a - med);
            }

            System.out.println(sums);
        }
    }
}
