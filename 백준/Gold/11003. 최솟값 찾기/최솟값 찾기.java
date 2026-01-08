import java.io.*;
import java.util.*;

public class Main {

    static int N, L;
    static Deque<int[]> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());
            int startIndex = Math.max(i - L + 1, 1);

            while (!deque.isEmpty() && deque.peekFirst()[0] < startIndex) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast()[1] > value) {
                deque.pollLast();
            }

            deque.offerLast(new int[] {i, value});
            sb.append(deque.peekFirst()[1]).append(" ");
        }

        System.out.print(sb);
        br.close();
    }
}
