import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, max;
    static int[] nums;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, nums[i]);
        }
        visited = new int[max + 1];

        valid();
        System.out.print(solve());
        br.close();
    }

    public static void valid() {
        for (int i = 2; i <= max; i++) {
            if (visited[i] == 1) continue;
            for (int j = i * 2; j <= max; j += i) {
                visited[j] = 1;
            }
        }
    }

    public static long solve() {
        long result = 1;

        for (int num : nums) {
            if (visited[num] == 1) continue;
            result *= num;
            visited[num] = 1;
        }

        return result == 1 ? -1 : result;
    }
}
