import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String commend = br.readLine();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        System.out.printf("%.2f", solve(nums, commend));
        br.close();
    }

    public static double solve(int[] nums, String commend) {
        char[] commendCharArray = commend.toCharArray();
        Stack<Double> stack = new Stack<>();

        for (char c : commendCharArray) {
            if (c != '+' && c != '-' && c != '*' && c != '/') {
                stack.push((double)nums[c - 'A']);
            }
            else {
                double right = stack.pop();
                double left = stack.pop();

                if (c == '+') stack.push(left + right);
                else if (c == '-') stack.push(left - right);
                else if (c == '*') stack.push(left * right);
                else stack.push(left / right);
            }
        }

        return stack.pop();
    }
}
