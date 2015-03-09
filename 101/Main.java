
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int blocks = sc.nextInt();
        sc.nextLine();

        List<LinkedList<Integer>> stacks = new ArrayList<>();
        for (int i = 0; i < blocks; i++) {
            LinkedList<Integer> l = new LinkedList<>();
            l.add(i);
            stacks.add(l);
        }

        while (sc.hasNext()) {
            String cmd = sc.nextLine();
            if (cmd.equals("quit")) {
                break;
            }

            String[] parts = cmd.split(" ");
            int a = Integer.parseInt(parts[1]);
            int b = Integer.parseInt(parts[3]);
            if (a == b) {
                continue;
            }
            if (parts[0].equals("move")) {
                if (parts[2].equals("onto")) {
                    int as = moveBack(stacks, a, a);
                    int bs = moveBack(stacks, b, b);
                    stacks.get(bs).addLast(stacks.get(as).pollLast());
                } else {
                    int as = moveBack(stacks, a, a);
                    stacks.get(findStack(stacks, b)).addLast(stacks.get(as).pollLast());
                }
            } else if (parts[0].equals("pile")) {
                if (parts[2].equals("onto")) {
                    int bs = moveBack(stacks, b, b);
                    pile(stacks, findStack(stacks, a), findStack(stacks, b), a);
                } else {
                    pile(stacks, findStack(stacks, a), findStack(stacks, b), a);
                }
            }
        }

        int i = 0;
        for (LinkedList<Integer> s : stacks) {
            String list = "";
            for (int a : s) {
                list += " " + a;
            }
            System.out.println(" " + i + ":" + list);
            i++;
        }
    }

    public static void pile(List<LinkedList<Integer>> stacks, int from, int to, int block) {
        LinkedList<Integer> frs = stacks.get(from);
        LinkedList<Integer> tos = stacks.get(to);

        LinkedList<Integer> tmp = new LinkedList<>();
        while (tmp.size() == 0 || tmp.peekLast() != block) {
            tmp.addLast(frs.pollLast());
        }
        while (tmp.size() != 0) {
            tos.addLast(tmp.pollLast());
        }
    }

    public static int findStack(List<LinkedList<Integer>> stacks, int block) {
        // find the block
        int stack = -1;
        int i = 0;
        for (LinkedList<Integer> s : stacks) {
            if (s.contains(block)) {
                stack = i;
                break;
            }
            i++;
        }
        return stack;
    }

    public static int moveBack(List<LinkedList<Integer>> stacks, int block, int until) {
        // find the block
        int stack = findStack(stacks, block);

        LinkedList<Integer> s = stacks.get(stack);
        while (s.peekLast() != until) {
            int el = s.pollLast();
            stacks.get(el).addLast(el);
        }
        return stack;
    }

}
