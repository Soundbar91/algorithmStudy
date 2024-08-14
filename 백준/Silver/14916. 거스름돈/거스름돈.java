import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        if (n == 1 || n == 3) return -1;
        if (n == 2 || n == 4) return n / 2;

        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (dp[i - 5] == 0 && dp[i - 2] == 0) continue;
            else if (dp[i - 5] == 0) dp[i] = dp[i - 2] + 1;
            else if (dp[i - 2] == 0) dp[i] = dp[i - 5] + 1;
            else dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
        }

        return dp[n] != 0 ? dp[n] : -1;
    }

}
