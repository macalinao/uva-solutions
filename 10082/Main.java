
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            char[] s = sc.nextLine().toLowerCase().toCharArray();
            transform(s);
            System.out.println(String.valueOf(s).toUpperCase());
        }
    }

    static char[] map = new char[127];

    static {
        char[] arr = "wqsaxzewdscxrefdvctrgfbvythgnbuyjhmniukj,moilk.,po;l/.[p';][\\]213243546576879809-0=-1`".toCharArray();
        for (int i = 0; i < arr.length; i += 2) {
            map[(int) arr[i]] = arr[i + 1];
        }
    }

    static void transform(char[] s) {
        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case ' ':
                    break;
                default:
                    s[i] = map[(int) s[i]];
            }
        }
    }
}
