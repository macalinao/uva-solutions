
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        while (sc.hasNext()) {
            int next = sc.nextInt();
            list.add(next);
            Collections.sort(list);
            if (list.size() % 2 == 0) {
                System.out.println((int) ((double) list.get(list.size() / 2 - 1) + (double) list.get(list.size() / 2)) / 2);
            } else {
                System.out.println(list.get(list.size() / 2));
            }
        }
    }
}