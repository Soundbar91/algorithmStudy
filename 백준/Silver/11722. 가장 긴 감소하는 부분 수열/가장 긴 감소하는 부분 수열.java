import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = -1;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.print(result);
    }
}
