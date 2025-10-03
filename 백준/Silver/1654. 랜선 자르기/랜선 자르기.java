import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        nums = new long[K];
        for (int i = 0; i < K; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(nums);

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        long left = 1;
        long right = nums[K - 1];

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = count(mid);

            if (count < N) right = mid - 1;
            else left = mid + 1;
        }

        return right;
    }

    public static long count(long len) {
        long count = 0;

        for (int i = 0; i < K; i++) {
            count += nums[i] / len;
        }

        return count;
    }
}
