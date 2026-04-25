import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        BigInteger[][] dp = new BigInteger[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) dp[i][j] = new BigInteger("1");
                else dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
            }
        }

        return dp[N][M].toString();
    }
}
