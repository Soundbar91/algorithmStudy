import java.io.*;
import java.util.*;

public class Main {

    static int N, T = 1;
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            dp = new int[N][3];
            cost = new int[N][3];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    cost[i][j] = Integer.parseInt(st.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            solve();
            sb.append(T++).append(". ").append(dp[N - 1][1]).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static void solve() {
        // dp[0][0] = cost[0][0];
        // dp[0][1] = cost[0][0] + cost[0][1];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][1] + cost[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i][0]))) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i][1])) + cost[i][2];
        }
    }
}
