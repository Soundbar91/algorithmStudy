import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, result = -1;
    static int[][] point;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        point = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = point[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) dp[i][j] = dp[i - 1][j] + point[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + point[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[n][i]);
        }

        System.out.print(result);
        br.close();
    }
}
