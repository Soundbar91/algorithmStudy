import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] numArr;
    static int[][] dp;
    static int result = Integer.MAX_VALUE;;
    static int INF = 1000 * 1000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        numArr = new int[n][3];

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][3];

        result = calcDp(1, 2, 0);
        result = calcDp(0, 2, 1);
        result = calcDp(0, 1, 2);

        System.out.print(result);
    }

    public static int calcDp(int n1, int n2, int check){
        dp[0][check] = numArr[0][check];
        dp[0][n1] = dp[0][n2] = INF;

        for (int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + numArr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + numArr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + numArr[i][2];
        }

        return Math.min(result, Math.min(dp[n - 1][n1], dp[n - 1][n2]));
    }
}
