
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        main:
        while (sc.hasNext()) {
            String s = sc.nextLine();
            if (s.equals("#")) {
                return;
            }

            char[] arr = s.toCharArray();
            for (int i = arr.length - 1; i >= 1; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] < arr[i]) {
                        // swap
                        char tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;

                        //sort rest
                        Arrays.sort(arr, j + 1, arr.length);

                        System.out.println(String.valueOf(arr));
                        continue main;
                    }
                }
            }

            System.out.println("No Successor");
        }
    }
}
