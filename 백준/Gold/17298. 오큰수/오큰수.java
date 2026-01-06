import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = -1;
            int value = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < value) {
                nums[stack.peek()[0]] = value;
                stack.pop();
            }

            stack.push(new int[] {i, value});
        }

        for (int i = 0; i < N; i++) {
            sb.append(nums[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
