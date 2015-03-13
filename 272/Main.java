
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder s = new StringBuilder();
        while (sc.hasNext()) {
            s.append(sc.nextLine() + "\n");
        }

        boolean open = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '"') {
                s.replace(i, i + 1, open ? "``" : "''");
                i++;
                open = !open;
            }
        }
        System.out.print(s.toString());
    }
}
