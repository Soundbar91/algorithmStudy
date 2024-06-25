import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> plus = new PriorityQueue<>();
        Queue<Integer> minus = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (plus.isEmpty() && minus.isEmpty()) sb.append(0).append('\n');
                else {
                    int plusPeek = Integer.MAX_VALUE;
                    if (!plus.isEmpty()) plusPeek = plus.peek();
                    int minusPeek = Integer.MAX_VALUE;
                    if (!minus.isEmpty()) minusPeek = minus.peek();

                    if (plusPeek == Math.abs(minusPeek)) sb.append(minus.remove()).append('\n');
                    else {
                        sb.append(plusPeek > Math.abs(minusPeek) ? minus.remove() : plus.remove()).append('\n');
                    }
                }
            }
            else {
                if (input > 0) plus.offer(input);
                else minus.offer(input);
            }
        }

        System.out.print(sb);
        br.close();
    }
}
