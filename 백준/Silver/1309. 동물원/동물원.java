import java.io.*;
import java.util.*;

/**
 * 1309. 동물원
 * 가로로 두칸 세로로 N칸인 우리
 * 사자를 가둘 때, 가로로도 세로로도 붙어 있게 배치할 수는 없다.
 *
 * 사자를 배치하는 경우의 수가 몇 가지인지를 알아내는 프로그램
 * 사자를 한 마리도 배치하지 않는 경우도 하나의 경우의 수
 *
 * 왼쪽에 두거나, 오른쪽에 두거나, 아예 안 두거나 -> 하나의 칸에서 경우의 수가 3개가 나옴
 * 왼쪽에 두면 -> 그다음에는 오른쪽 혹은 아예 안 둠
 * 오른쪽에 두면 -> 그다음에는 왼쪽 혹은 아예 안 둠
 * 아예 안 두면 -> 그다음에는 왼족 혹은 오른쪽에 두거나 아예 안둠
 * 그렇다면 이전에 어디에 두었는지를 알아야함
 *
 * dp[i][0] -> 왼쪽에 둔 경우의 수
 * dp[i][1] -> 오른족에 둔 경우의 수
 * dp[i][2] -> 아예 안 둔 경우의 수
 */

public class Main {

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];

        System.out.print(solve() % 9901);
        br.close();
    }

    public static int solve() {
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
        }

        return (dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2]) % 9901;
    }
}
