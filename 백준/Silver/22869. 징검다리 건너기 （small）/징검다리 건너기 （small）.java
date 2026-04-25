import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] stone;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stone = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) stone[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[N];
        dp[0] = true; // 첫 번째 돌은 시작점이므로 true로 설정

        for (int i = 0; i < N; i++) {
            if (dp[i]) {
                for (int j = i + 1; j < N; j++) {
                    if ((j - i) * (Math.abs(stone[i] - stone[j]) + 1) <= K) {
                        dp[j] = true;
                    }
                }
            }
        }

        System.out.print(dp[N - 1] ? "YES" : "NO");
        br.close();
    }
}
