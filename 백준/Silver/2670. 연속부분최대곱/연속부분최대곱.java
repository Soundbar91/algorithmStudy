import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static double[] nums;
    static double[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new double[N];
        dp = new double[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = nums[0];
        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
        }

        double result = 0.0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.printf("%.3f", result);
    }
}
