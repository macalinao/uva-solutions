
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            System.out.println(balanced(sc.nextLine()) ? "Yes" : "No");
        }
    }

    static boolean balanced(String s) {
        LinkedList<Character> k = new LinkedList<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            Character top = k.peek();
            switch (c) {
                case '(':
                case '[':
                    k.push(c);
                    break;
                case ')':
                    if (top == null) {
                        return false;
                    }
                    if (top == '(') {
                        k.pop();
                    }
                    break;
                case ']':
                    if (top == null) {
                        return false;
                    }
                    if (top == '[') {
                        k.pop();
                    }
                    break;
            }
        }
        return k.isEmpty();
    }
}
