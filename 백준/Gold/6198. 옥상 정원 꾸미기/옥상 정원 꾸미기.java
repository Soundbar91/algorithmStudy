import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long result;
    static int[] nums;
    static Stack<long[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            int value = nums[i];
            long count = 0;

            while (!stack.isEmpty() && stack.peek()[0] < value) {
                count += stack.pop()[1];
                count++;
            }

            stack.push(new long[] {value, count});
            result += count;
        }

        System.out.print(result);
        br.close();
    }
}
