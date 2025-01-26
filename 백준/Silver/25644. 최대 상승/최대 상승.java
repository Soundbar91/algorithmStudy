import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int result = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - prev < 0) {
                prev = nums[i];
            }
            else result = Math.max(result, nums[i] - prev);
        }

        return result;
    }
}
