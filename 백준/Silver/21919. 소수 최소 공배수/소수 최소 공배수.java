import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                        .sorted().mapToInt(Integer::parseInt).toArray();

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        long result = 1;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            boolean update = false;
            if (list.contains(nums[i])) continue;

            if (nums[i] == 2) {
                result *= nums[i];
                list.add(nums[i]);
                continue;
            }

            for (int j = 2; j <= Math.sqrt(nums[i]); j++) {
                if (nums[i] % j == 0) {
                    update = true;
                    break;
                }
            }

            if (!update) {
                list.add(nums[i]);
                result *= nums[i];
            }
        }

        return result == 1 ? -1 : result;
    }
}
