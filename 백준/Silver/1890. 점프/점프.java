import java.io.*;
import java.util.*;

public class Main {

    static int N, x, y;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == x && j == y) {
                    break;
                }

                if (i + map[i][j] < N) {
                    dp[i + map[i][j]][j] += dp[i][j];
                }

                if (j + map[i][j] < N) {
                    dp[i][j + map[i][j]] += dp[i][j];
                }
            }
        }
        System.out.print(dp[x][y]);
    }
}
