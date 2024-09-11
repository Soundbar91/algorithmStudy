import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    static int n;
    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new BigInteger[n + 1];

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        if (n == 0) return "0";
        dp[0] = BigInteger.ZERO;
        dp[1] = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        return dp[n].toString();
    }
}
