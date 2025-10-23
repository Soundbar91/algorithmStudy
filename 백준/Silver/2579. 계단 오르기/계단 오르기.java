import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int len;
    static int[] floor;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        len = Integer.parseInt(br.readLine());
        floor = new int[len + 1];
        dp = new int[len + 1][3];

        for (int i = 1; i <= len; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }
        
        if (len == 1) {
            System.out.println(floor[1]);
            return;
        } else if (len == 2) {
            System.out.println(floor[1] + floor[2]);
            return;
        }

        dp[1][1] = floor[1];
        dp[1][2] = 0;
        dp[2][1] = floor[2];
        dp[2][2] = floor[1] + floor[2];

        for (int i = 3; i <= len; i++) {
            dp[i][1] = floor[i] + Math.max(dp[i - 2][1], dp[i - 2][2]);
            dp[i][2] = floor[i] + dp[i - 1][1];
        }
        
        System.out.print(Math.max(dp[len][1], dp[len][2]));
        br.close();
    }
}
