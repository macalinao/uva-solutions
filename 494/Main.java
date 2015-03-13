
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] arr = sc.nextLine().toCharArray();
            int ct = 0;

            for (int i = 0; i < arr.length - 1; i++) {
                if (!Character.isAlphabetic(arr[i + 1]) && Character.isAlphabetic(arr[i])) {
                    ct++;
                }
            }
            if (Character.isAlphabetic(arr[arr.length - 1])) {
                ct++;
            }
            System.out.println(ct);
        }
    }
}
