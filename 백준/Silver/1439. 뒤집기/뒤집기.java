import java.io.*;
import java.util.*;

public class Main {

    static int one, zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        if (S.charAt(0) == '0') {
            zero++;
        } else if  (S.charAt(0) == '1') {
            one++;
        }

        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i + 1)) {
                if (S.charAt(i + 1) == '0') {
                    zero++;
                } else if (S.charAt(i + 1) == '1') {
                    one++;
                }
            }
        }

        System.out.print(Math.min(one, zero));
        br.close();
    }
}