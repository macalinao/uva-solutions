
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(rev(arr[i]));
                if (i != arr.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static String rev(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            char tmp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = tmp;
        }
        return String.valueOf(arr);
    }
}
