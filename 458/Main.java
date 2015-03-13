
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        OutputStreamWriter out = new OutputStreamWriter(System.out, "ISO-8859-1");

        String input, decoded;

        while ((input = br.readLine()) != null) {
            decoded = "";
            for (int i = 0; i < input.length(); i++) {

                decoded += (char) (input.charAt(i) - 7);
            }

            out.write(decoded + '\n');
            out.flush();
        }
    }
}
