import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];
        dp[2] = 3;
        dp[4] = 11;

        for (int i = 6; i <= n; i++){
            if (i % 2 != 0) continue;

            dp[i] = dp[i - 2] * dp[2];

            for (int j = i - 4; j >= 0; j -= 2){
                dp[i] += (dp[j] * 2);
            }

            dp[i] += 2;
        }
        System.out.print(dp[n]);
    }
}
