import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int len;
    static int[] floor;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        len = Integer.parseInt(br.readLine());
        floor = new int[len + 1];
        dp = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = floor[1];
        if (len >= 2) dp[2] = floor[1] + floor[2];

        for (int i = 3; i <= len; i++) {
            dp[i] = floor[i] + Math.max(dp[i - 2], dp[i - 3] + floor[i - 1]);
        }

        System.out.print(dp[len]);
        br.close();
    }
}
