import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][2];
        dp[0][0] = numArr[0];
        dp[0][1] = numArr[0];

        for (int i = 1; i < n; i++){
            dp[i][0] = Math.max(dp[i - 1][0] + numArr[i], numArr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + numArr[i], dp[i - 1][0]);
        }

        int result = -1 * Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.print(result);
    }
}
