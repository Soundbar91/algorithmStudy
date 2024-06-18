import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solve(nums, n));
        br.close();
    }

    public static String solve(int[] nums, int n) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append('+').append('\n');

            while (!stack.isEmpty() && stack.peek() == nums[index]) {
                stack.pop();
                sb.append('-').append('\n');
                index++;
            }
        }

        if (index != n) {
            return "NO";
        }

        return sb.toString();
    }
}
