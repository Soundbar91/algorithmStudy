import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i > 0; i--) {
            if (nums[i] - nums[i - 1] <= 0) {
                result += (nums[i - 1] - (nums[i] - 1));
                nums[i - 1] = nums[i] - 1;
            }
        }

        System.out.print(result);
        br.close();
    }
}