import java.io.*;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int standard = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (nums[i] == n) standard = i;
        }

        System.out.print(valid(standard, nums) ? solve(nums, standard, n) : "NO");
        br.close();
    }

    public static boolean valid(int standard, int[] nums) {
        return IntStream.range(standard + 1, nums.length - 1).noneMatch(i -> nums[i] < nums[i + 1]);
    }

    public static String solve(int[] nums, int standard, int n) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+\n");

            while (!stack.isEmpty() && stack.peek() == nums[index]) {
                index++;
                stack.pop();
                sb.append("-\n");
            }
        }
        
        if (index != n) {
            return "NO";
        }

        return sb.toString();
    }
}
