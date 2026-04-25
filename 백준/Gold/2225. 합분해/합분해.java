import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[201][201];

        for (int i = 1; i <= 200; i++){
            dp[1][i] = i;
        }

        for (int i = 2; i <= 200; i++){
            for (int j = 1; j <= 200; j++){
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        System.out.print(dp[N][K] % 1000000000);
    }
}
