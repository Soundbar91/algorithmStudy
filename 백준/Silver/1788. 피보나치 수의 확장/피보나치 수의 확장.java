import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] dp = new int[2_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()) + 1_000_000;

        dp[999_999] = 1;
        dp[1_000_000] = 0;
        dp[1_000_001] = 1;

        for (int i = 1_000_002; i <= 2_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000_000;
        }

        for (int i = 999_998; i >= 0; i--) {
            dp[i] = (dp[i + 2] - dp[i + 1])  % 1_000_000_000;
        }

        System.out.println(dp[n] == 0 ? 0 : dp[n] > 0 ? 1 : -1);
        System.out.print(Math.abs(dp[n]));
        br.close();
    }
}
