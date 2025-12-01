import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 987654321;
        }

        dp[0] = 0;
        solve();
        System.out.print(dp[N - 1] == 987654321 ? -1 : dp[N - 1]);
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j >= N) continue;
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1) ;
            }
        }
    }
}
