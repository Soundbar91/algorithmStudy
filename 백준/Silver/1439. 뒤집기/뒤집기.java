import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int zero = 0, one = 0;

        if (str.charAt(0) == '0') zero++;
        else one++;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                if (str.charAt(i + 1) == '0') zero++;
                else one++;
            }
        }

        if (zero == 0 && one == 0) return 0;
        else return Math.min(one, zero);
    }
}
