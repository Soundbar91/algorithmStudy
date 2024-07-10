import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, K;
    static boolean[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nums = new boolean[N + 1];

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (nums[i]) continue;
            if (++count == K) return i;

            for (int j = i * 2; j <= N; j += i) {
                if (nums[j]) continue;

                nums[j] = true;
                if (++count == K) return j;
            }
        }

        return -1;
    }
}
