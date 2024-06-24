import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int N;
    static Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) sb.append(maxHeap.isEmpty() ? 0 : maxHeap.remove()).append('\n');
            else maxHeap.add(value);
        }

        System.out.print(sb);
        br.close();
    }
}
