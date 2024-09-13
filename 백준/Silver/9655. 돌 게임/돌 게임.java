import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        int[] dp = new int[335];
        dp[0] = N;

        for (int i = 1; i <= 335; i++) {
            if (dp[i - 1] > 3) dp[i] = dp[i - 1] - 3;
            else if (dp[i - 1] > 1) dp[i] = dp[i - 1] - 1;
            else return i % 2 != 0 ? "SK" : "CY";
        }

        return null;
    }
}
