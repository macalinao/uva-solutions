
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ln = sc.nextLine();
            if (ln.trim().isEmpty()) {
                System.out.println();
                continue;
            }

            char[] arr = ln.toCharArray();
            int a = 0;
            for (char c : arr) {
                // Check if digit
                if (Character.isDigit(c)) {
                    a += Integer.parseInt(Character.toString(c));
                    continue;
                }

                // new line
                if (c == '!') {
                    System.out.println();
                    continue;
                }

                // build maze
                if (c == 'b') {
                    c = ' ';
                }
                StringBuilder b = new StringBuilder();
                for (int i = 0; i < a; i++) {
                    b.append(c);
                }
                a = 0;
                System.out.print(b.toString());
            }
            
            System.out.println();
        }
    }
}
