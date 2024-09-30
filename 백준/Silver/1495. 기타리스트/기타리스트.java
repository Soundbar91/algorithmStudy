import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, S, M;
    static int[] volumes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        volumes = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        boolean[][] dp = new boolean[N + 1][M + 1];

        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            boolean update = false;

            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j]) {

                    int plus = j + volumes[i];
                    if (plus <= M) {
                        update = true;
                        dp[i][plus] = true;
                    }

                    int minus = j - volumes[i];
                    if (minus >= 0) {
                        update = true;
                        dp[i][minus] = true;
                    }
                }
            }

            if (!update) return -1;
        }

        int result = 0;

        for (int i = 0; i <= M; i++) {
            result = Math.max(result, dp[N][i] ? i : -1);
        }

        return result;
    }
}
