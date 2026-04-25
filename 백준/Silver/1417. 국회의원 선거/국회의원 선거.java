import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int result = 0;
        int dasom = nums[0];

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < N; i++) queue.add(nums[i]);

        while (!queue.isEmpty() && dasom <= queue.peek()) {
            dasom++;
            result++;
            queue.add(queue.poll() - 1);
        }

        return result;
    }
}
