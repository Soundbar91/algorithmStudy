import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long result;
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            int count = 0;

            while (!stack.isEmpty() && stack.peek()[0] < value) {
                stack.pop();
                result++;
            }

            if (!stack.isEmpty()) {
                if (stack.peek()[0] == value) {
                    count += stack.peek()[1];
                }
                count++;
            }
            result += count;
            stack.push(new int[] {value, count});
        }

        System.out.print(result);
        br.close();
    }
}
