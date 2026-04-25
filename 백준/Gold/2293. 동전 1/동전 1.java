import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N];
        for (int i = 0; i < N; i++) coin[i] = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int[] dp = new int[K + 1];

        dp[0] = 1;

        for (int value : coin) {
            for (int i = value; i <= K; i++) {
                dp[i] += dp[i - value];
            }
        }

        return dp[K];
    }
}
