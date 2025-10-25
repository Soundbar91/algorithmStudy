import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int X;
    static int[] dp;
    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(br.readLine());
        dp = new int[X + 1];
        prev = new int[X + 1];

        dp[1] = 0;
        prev[1] = -1;

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;
            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2]) {
                    prev[i] = i / 2;
                }
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3]) {
                    prev[i] = i / 3;
                }
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[X]);

        int prevIndex = X;
        while (prevIndex != -1) {
            System.out.print(prevIndex + " ");
            prevIndex = prev[prevIndex];
        }
        br.close();
    }
}
