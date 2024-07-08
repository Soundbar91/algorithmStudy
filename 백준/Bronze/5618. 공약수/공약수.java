import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int n;
    static int[] nums;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        solve();
    }

    public static void solve() {
        int end;

        if (n == 3) {
            end = Math.max(nums[0], Math.max(nums[1], nums[2]));
            for (int i = 1; i <= end; i++) {
                if (nums[0] % i == 0 && nums[1] % i == 0 && nums[2] % i == 0) result.add(i);
            }
        }
        else {
            end = Math.max(nums[0], nums[1]);

            for (int i = 1; i <= end; i++) {
                if (nums[0] % i == 0 && nums[1] % i == 0) result.add(i);
            }
        }

        result.forEach(System.out::println);
    }
}
