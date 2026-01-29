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

        for (int i = 0; i < N; i++) {
            lowerBound(i);
        }

        System.out.print(result);
    }

    public static void lowerBound(int start) {
        int left = start;
        int right = N - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int calc = Math.abs(nums[start] - nums[mid]);

            if (calc >= M) {
                right = mid - 1;
                result = Math.min(result, calc);
            } else {
                left = mid + 1;
            }
        }
    }
}