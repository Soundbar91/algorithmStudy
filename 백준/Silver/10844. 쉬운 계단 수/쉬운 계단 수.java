import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, result = 0;
    static int[][] dp = new int[101][10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 100; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dp[i][j] = (dp[i - 1][j + 1]) % 1_000_000_000;
                }
                else if (j == 9) {
                    dp[i][j] = (dp[i - 1][j - 1]) % 1_000_000_000;
                }
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])  % 1_000_000_000;
                }
            }
        }

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % 1_000_000_000;
        }

        System.out.print(result);
        br.close();
    }
}
