import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M  = Integer.parseInt(st.nextToken());
        N  = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        System.out.println(solve());
        br.close();
    }

    public static long solve() {
        int left = 1;
        int right = nums[N - 1];
        long result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = cnt(mid);

            if (cnt < M) {
                right = mid - 1;
            } else {
                left = mid + 1;
                result = Math.max(result, mid);
            }
        }

        return result;
    }

    public static int cnt(int value) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += (nums[i] / value);
        }

        return cnt;
    }
}
