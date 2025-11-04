import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;

        int weight = 4;

        for (int i = 9; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[weight++];
        }

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }

        br.close();
    }
}
