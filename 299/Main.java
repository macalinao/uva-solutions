
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            swaps = 0;
            int l = sc.nextInt();
            int[] arr = new int[l];
            for (int i = 0; i < l; i++) {
                arr[i] = sc.nextInt();
            }
            swap(arr);
            System.out.println("Optimal train swapping takes " + swaps + " swaps.");
        }
    }

    static int swaps = 0;

    static void swap(int[] arr) {
        boolean sorted = true;
        for (;;) {
            sorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swaps++;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
}
