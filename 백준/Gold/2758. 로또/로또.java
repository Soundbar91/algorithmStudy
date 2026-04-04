import java.io.*;
import java.util.*;

/**
 * 2758. 로또
 * 각 숫자는 이전에 고른 수보다 적어도 2배가 되도록 고름 -> 3배만 넘어가지 않으면 되는 듯
 * 재귀 -> 시간초과 발생 / why : 트리 폭팔
 * DP -> dp[i][j] = i번째 수를 j로 골랐을 때 구매할 수 있는 로또의 개수
 */

public class Main {

    static int T, n, m;
    static long[][] dp = new long[11][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= 10; i++) {
            for (int j = 1; j <= 2000; j++) {
                for (int k = 1; k <= j / 2; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            long count = 0;
            for (int i = m; i >= 1; i--) {
                count += dp[n][i];
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
