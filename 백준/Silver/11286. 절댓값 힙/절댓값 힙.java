import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) return o1 - o2;
            else return Math.abs(o1) - Math.abs(o2);
        });

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) absHeap.add(x);
            else {
                if (absHeap.isEmpty()) sb.append(0).append('\n');
                else sb.append(absHeap.poll()).append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }
}
