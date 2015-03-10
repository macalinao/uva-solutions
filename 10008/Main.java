
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = "";
        while (sc.hasNext()) {
            s += sc.nextLine();
        }
        s = s.toUpperCase();

        Map<Character, Integer> ct = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                continue;
            }

            if (!ct.containsKey(c)) {
                ct.put(c, 1);
            } else {
                ct.put(c, ct.get(c) + 1);
            }

        }

        List<Map.Entry<Character, Integer>> l = new ArrayList<>(ct.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<Character, Integer>>() {

            @Override
            public int compare(Map.Entry<Character, Integer> t, Map.Entry<Character, Integer> t1) {
                int a = t1.getValue().compareTo(t.getValue());
                if (a != 0) {
                    return a;
                }
                return t.getKey().compareTo(t1.getKey());
            }
        });
        for (Map.Entry<Character, Integer> e : l) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
