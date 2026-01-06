import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek()[1] >= value) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[] {i, value});
        }

        br.close();
    }
}
