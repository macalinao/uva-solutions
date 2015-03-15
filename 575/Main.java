
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int l = s.length();
            if (l == 1 && s.equals("0")) {
                return;
            }
            int num = 0;
            for (char c : s.toCharArray()) {
                num += Integer.valueOf(Character.toString(c)) * ((2 << --l) - 1);
            }
            System.out.println(num);
        }
    }
}
