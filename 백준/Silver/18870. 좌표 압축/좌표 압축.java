import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] targets;
    static long[] tmp;
    static List<Long> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        targets = new long[N];
        tmp = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            targets[i] = Long.parseLong(st.nextToken());
        }

        System.arraycopy(targets, 0, tmp, 0, N);
        Arrays.sort(tmp);

        for (int i = 0; i < N; i++) {
            if (i == 0 || nums.get(nums.size() - 1) != tmp[i]) {
                nums.add(tmp[i]);
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(lowerBound(targets[i])).append(" ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(long target) {
        int left = 0;
        int right = nums.size();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target <= nums.get(mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
