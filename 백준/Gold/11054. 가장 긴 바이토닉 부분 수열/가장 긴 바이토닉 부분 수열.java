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
        dp[0][0] = 1;
        dp[n - 1][1] = 1;

        for (int i = 1; i < n; i++){
            int maxNum = 0;
            for (int j = 0; j < i; j++){
                if(numArr[i] > numArr[j]) maxNum = Math.max(dp[j][0], maxNum);
            }
            dp[i][0] = maxNum + 1;
        }

        for (int i = n - 2; i > -1; i--){
            int minNum = 0;
            for (int j = n - 1; j > i; j--){
                if (numArr[i] > numArr[j]) minNum = Math.max(dp[j][1], minNum);
            }
            dp[i][1] = minNum + 1;
        }

        int result = 0;
        for (int i = 0; i < n; i++){
            result = Math.max(result, dp[i][0] + dp[i][1] - 1);
        }

        System.out.print(result);
    }
}
