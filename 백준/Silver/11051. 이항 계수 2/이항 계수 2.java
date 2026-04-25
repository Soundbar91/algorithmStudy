import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= Math.min(i, K); j++) {
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
            }
        }

        return dp[N][K];
    }
}
