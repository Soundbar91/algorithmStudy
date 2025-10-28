import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */

public class Main {
    static int[] score;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        score = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(score[0]);
        } else if (n == 2) {
            System.out.println(score[0] + score[1]);
        } else if (n == 3) {
            dp[0] = score[0];
            dp[1] = score[0] + score[1];
            dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);
            dp[2] = Math.max(dp[2], score[0] + score[1]);
            System.out.println(dp[2]);
        } else {
            dp[0] = score[0];
            dp[1] = score[0] + score[1];
            dp[2] = Math.max(score[0] + score[2], score[1] + score[2]);
            dp[3] = Math.max(dp[0] + score[2] + score[3], dp[1] + score[3]);
            for (int i = 4; i < n; i++) {
                /*
                 * dp[i - 4] + score[i - 1] + score[i] 먹안안먹먹
                 * dp[i - 3] + score[i - 1] + score[i] 안먹먹
                 * dp[i - 2] + score[i] 먹안먹
                 */
                dp[i] = Math.max(dp[i - 3] + score[i - 1] + score[i], dp[i - 4] + score[i - 1] + score[i]);
                dp[i] = Math.max(dp[i], dp[i - 2] + score[i]);
            }
            System.out.println(Math.max(dp[n - 1], dp[n - 2]));
            br.close();
        }
    }
}
