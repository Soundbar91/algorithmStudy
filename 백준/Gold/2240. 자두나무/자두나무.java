import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int W;
    static int[] trees;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        trees = new int[T + 1];
        for (int i = 1; i <= T; i++) trees[i] = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        dp = new int[T + 1][W + 1];
        int curPos = 1;
        int result = -1;

        for (int i = 1; i <= T; i++) {
            int treePos = trees[i];

            for (int j = 0; j <= W; j++) {
                if (j == 0) {
                    curPos = 1;
                    dp[i][j] = treePos == curPos ? dp[i - 1][j] + 1 : dp[i - 1][j];
                    continue;
                }

                curPos = j % 2 == 0 ? 1 : 2;
                addPlum(i, j, curPos, treePos);

                result = Math.max(dp[i][j], result);
            }
        }

        return result;
    }

    public static void addPlum(int i, int j, int curPos, int treePos) {
        if (curPos == treePos)
            dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1]);
        else
            dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
    }
}
