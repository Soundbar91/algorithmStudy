import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int M;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T  = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            money = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) money[i] = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());
            System.out.println(solve());
        }

        br.close();
    }

    public static long solve() {
        long[] dp = new long[M + 1];
        dp[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = money[i]; j <= M; j++) {
                dp[j] += dp[j - money[i]];
            }
        }

        return dp[M];
    }
}
