import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M;
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[M][N];
        for (int i = 0; i < M; i++) Arrays.fill(dp[i], -1);

        System.out.print(solve(0, 0));
        br.close();
    }

    public static long solve(int x, int y) {
        if (x == M - 1 && y == N - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int ux = x + dx[i];
            int uy = y + dy[i];

            if (ux < 0 || ux >= M || uy < 0 || uy >= N) continue;
            if (map[x][y] > map[ux][uy]) dp[x][y] += solve(ux, uy);
        }

        return dp[x][y];
    }
}
