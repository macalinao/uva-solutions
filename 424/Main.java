
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger sum = BigInteger.ZERO;
        while (sc.hasNext()) {
            sum = sum.add(new BigInteger(sc.nextLine()));
        }
        System.out.println(sum.toString());
    }
}