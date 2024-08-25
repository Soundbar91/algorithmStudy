import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] dx = {0, -1, -1};
    static int[] dy = {-1, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int[][] dp = new int[N][M];

        dp[0][0] = map[0][0];
        for (int i = 1; i < M; i++) dp[0][i] = dp[0][i - 1] + map[0][i];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                List<Integer> candys = new ArrayList<>();

                for (int k = 0; k < 3; k++) {
                    int ux = i + dx[k];
                    int uy = j + dy[k];

                    if (!valid(ux, uy)) continue;
                    candys.add(dp[ux][uy]);
                }

                for (int candy : candys) {
                    dp[i][j] = Math.max(dp[i][j], candy + map[i][j]);
                }

            }
        }

        return dp[N - 1][M - 1];
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
