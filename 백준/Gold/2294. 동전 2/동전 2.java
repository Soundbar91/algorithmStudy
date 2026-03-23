import java.io.*;
import java.util.*;

/**
 * n가지 종류의 동전
 * 가치의 합이 k원이 되도록
 * 동전의 개수가 최소
 *
 * dp[i] = i 가치를 만드는데 필요한 동전의 최소 개수
 */

public class Main {

    static int n, k;
    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n];
        dp = new int[k + 1];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = nums[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        }

        System.out.println(dp[k] == 987654321 ? -1 : dp[k]);
        br.close();
    }
}
