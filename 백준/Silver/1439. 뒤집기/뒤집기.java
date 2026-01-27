import java.io.*;
import java.util.*;

public class Main {

    static int one, zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        for (int i = 1; i < S.length(); i++) {
            if (i == S.length() - 1) {
                if (S.charAt(i) == '0') {
                    zero++;
                } else if  (S.charAt(i) == '1') {
                    one++;
                }
            }
            
            if (S.charAt(i) != S.charAt(i - 1)) {
                if (S.charAt(i - 1) == '0') {
                    zero++;
                } else if (S.charAt(i - 1) == '1') {
                    one++;
                }
            }
        }

        System.out.print(Math.min(one, zero));
        br.close();
    }
}