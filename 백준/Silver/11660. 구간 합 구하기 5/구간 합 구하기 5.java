import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (j == 0) dp[i][j] = Integer.parseInt(st.nextToken());
                else dp[i][j] += dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            sb.append(solve(x1 - 1, y1 - 1, x2 - 1, y2 - 1)).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static long solve(int x1, int y1, int x2, int y2) {
        long result = 0;

        for (int i = x1; i <= x2; i++) {
            if (y1 - 1 < 0) result += dp[i][y2];
            else result += (dp[i][y2] - dp[i][y1 - 1]);
        }

        return result;
    }
}
