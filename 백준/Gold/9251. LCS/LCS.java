import java.io.*;

public class Main {
    static String A;
    static String B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int result = -1;

        for (int i = 0; i <= A.length(); i++) {
            for (int j = 0; j <= B.length(); j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                result = Math.max(result, dp[i][j]);
            }
        }

        return result;
    }
}
