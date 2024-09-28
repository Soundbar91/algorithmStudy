import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, X;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        int count = 0, sum = 0, max;

        for (int i = 0; i <= X - 1; i++) {
            sum += nums[i];
        }
        max = sum;
        count++;

        for (int i = 1; i < N - X + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + X - 1];
            if (sum == max) count++;
            else if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        if (max == 0) return "SAD";
        else {
            System.out.println(max);
            return String.valueOf(count);
        }
    }
}
