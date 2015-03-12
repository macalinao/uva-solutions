
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();

            Job[] jobs = new Job[n];
            for (int i = 0; i < n; i++) {
                jobs[i] = new Job();
                jobs[i].t = sc.nextInt();
                jobs[i].f = sc.nextInt();
                jobs[i].i = i + 1;
                jobs[i].s = (double) jobs[i].f / (double) jobs[i].t;
            }

            Arrays.sort(jobs);

            String s = "";
            for (Job j : jobs) {
                s += j.i + " ";
            }
            s = s.trim();
            System.out.println(s);
            if (t != 0) {
                System.out.println();
            }

        }
    }

    static class Job implements Comparable<Job> {

        int t;
        int f;
        int i;
        double s;

        @Override
        public int compareTo(Job o) {
            int ret = Double.valueOf(o.s).compareTo(s);
            if (ret != 0) {
                return ret;
            } else {
                return Integer.valueOf(i).compareTo(o.i);
            }
        }

    }
}
