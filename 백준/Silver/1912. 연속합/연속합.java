import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = nums[1];
        result = dp[1];
        
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.print(result);
        br.close();
    }
}
