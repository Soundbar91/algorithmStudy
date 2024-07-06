import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        solve("");
    }

    public static void solve(String str) {
        if (str.length() == N) {
            System.out.print(str);
            System.exit(0);
        }
        else {
            for (int i = 1; i <= 3; i++) {
                if (valid(str + i)) {
                    solve(str + i);
                }
            }
        }
    }

    public static boolean valid(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String left = str.substring(str.length() - i);
            String right = str.substring(str.length() - 2 * i, str.length() - i);
            if (left.equals(right)) return false;
        }

        return true;
    }
}
