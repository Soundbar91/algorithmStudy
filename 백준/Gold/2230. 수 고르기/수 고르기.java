import java.io.*;
import java.util.*;

public class Main {

    static int N, M, result = Integer.MAX_VALUE;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        solve();
        br.close();
    }

    public static void solve() {
        Arrays.sort(nums);
        int left = 0, right = 0;

        while (left < N && right < N) {
            int calc = Math.abs(nums[right] - nums[left]);

            if (calc < M) {
                right++;
            } else {
                left++;
                result = Math.min(result, calc);
            }
        }

        System.out.print(result);
    }
}