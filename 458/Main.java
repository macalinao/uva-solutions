
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] arr = sc.nextLine().toCharArray();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (char) ((short) arr[i] - 7 % 128);
            }
            System.out.println(String.valueOf(arr));
        }
    }
}
