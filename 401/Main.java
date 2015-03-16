
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            boolean p = palindrome(s);
            boolean m = mirrored(s);
            if (p && m) {
                System.out.println(s + " -- is a mirrored palindrome.");
            } else if (!p && m) {
                System.out.println(s + " -- is a mirrored string.");
            } else if (p && !m) {
                System.out.println(s + " -- is a regular palindrome.");
            } else if (!p && !m) {
                System.out.println(s + " -- is not a palindrome.");
            }
            System.out.println();
        }
    }

    static boolean palindrome(String s) {
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            char a = s.charAt(i);
            char b = s.charAt(s.length() - i - 1);
            if (a != b) {
                return false;
            }
        }
        return true;
    }

    static boolean mirrored(String s) {
        int half = s.length() / 2;
        for (int i = 0; i < half; i++) {
            char a = s.charAt(i);
            char b = s.charAt(s.length() - i - 1);
            Character bi = inv.get(b);
            if (bi == null || a != bi) {
                return false;
            }
        }

        // mid
        if (s.length() % 2 != 0) {
            Character i = inv.get(s.charAt(half));
            return i != null && i == s.charAt(half);
        }

        return true;
    }

    static Map<Character, Character> inv;

    static {
        inv = new HashMap<>();
        String s = "AAE3HHIIJLLJMMOOS2TTUUVVWWXXYYZ5112S3E5Z88";
        for (int i = 0; i < s.length(); i += 2) {
            inv.put(s.charAt(i), s.charAt(i + 1));
        }
    }

}
