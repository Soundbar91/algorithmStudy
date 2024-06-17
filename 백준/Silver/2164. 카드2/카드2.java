import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) queue.add(i);

        System.out.print(solve(N, queue));
        br.close();
    }

    public static int solve(int N, Queue<Integer> queue) {
        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        return queue.poll();
    }
}
