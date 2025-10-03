import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] nums;
    static int[] targets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        M = Integer.parseInt(br.readLine());
        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        br.close();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(upperBound(targets[i]) - lowerBound(targets[i])).append(" ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target <= nums[mid]) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public static int upperBound(int target) {
        int left = 0;
        int right = N;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
