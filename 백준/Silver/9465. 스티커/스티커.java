import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] numArr = new int[2][100001];
            int[][] dp = new int[2][100001];

            for (int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++){
                    numArr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = numArr[0][0];
            dp[1][0] = numArr[1][0];
            dp[0][1] = dp[1][0] + numArr[0][1];
            dp[1][1] = dp[0][0] + numArr[1][1];

            for (int i = 2; i < n; i++){
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + numArr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + numArr[1][i];
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append('\n');
        }
        System.out.print(sb);
    }
}
