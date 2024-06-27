import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int[] nums;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            M = Integer.parseInt(br.readLine());

            System.out.print(solve());
        }

        br.close();
    }

    public static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append((M + 1) / 2).append('\n');
        int count = 0;

        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < M; i++) {
            if (i % 10 == 0) st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());

            if (minHeap.size() == maxHeap.size()) maxHeap.add(value);
            else minHeap.add(value);

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int maxValue = maxHeap.poll();
                    int minValue = minHeap.poll();

                    maxHeap.add(minValue);
                    minHeap.add(maxValue);
                }
            }

            if (i % 2 == 0) {
                if (count == 9 || i == M - 1) {
                    sb.append(maxHeap.peek()).append('\n');
                    count = 0;
                }
                else {
                    sb.append(maxHeap.peek()).append(" ");
                }
                count++;
            }
        }

        return sb.toString();
    }
}
