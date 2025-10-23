import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int X;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        dp = new int[X + 1];
        Arrays.fill(dp, 987654321);
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        System.out.print(dp[X]);
        br.close();
    }
}
