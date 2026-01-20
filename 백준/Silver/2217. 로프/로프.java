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
        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            result = Math.max(result, nums[i] * (N - i));
        }

        System.out.print(result);
        br.close();
    }
}
