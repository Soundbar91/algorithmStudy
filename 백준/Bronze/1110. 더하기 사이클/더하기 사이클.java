import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solve(0, N);
    }

    public static void solve (int depth, int num) {
        if (depth != 0 && num == N) {
            System.out.print(depth);
            System.exit(0);
        }
        else {
            String str = String.valueOf(num);
            char right = str.charAt(str.length() - 1);

            if (num < 10) str = "0" + str;

            int n1 = str.charAt(0) - '0';
            int n2 = str.charAt(1) - '0';
            String sum = String.valueOf(n1 + n2);
            char left = sum.charAt(sum.length() - 1);

            StringBuilder sb = new StringBuilder();
            sb.append(right).append(left);

            solve(depth + 1, Integer.parseInt(sb.toString()));
        }
    }
}
