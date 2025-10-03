import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        System.out.println(solve());
        br.close();
    }

    public static int solve() {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                for (int k = 0; k <= j; k++) {
                    int target = nums[i] - (nums[j] + nums[k]);
                    if (target <= 0) {
                        continue;
                    }
                    if (binarySearch(k, j, target) != -1) {
                        return nums[i];
                    }
                }
            }
        }

        return 0;
    }

    public static int binarySearch(int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
