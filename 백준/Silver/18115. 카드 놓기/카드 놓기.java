import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine())
                .reverse().toString());
        for (int i = 1; i <= N; i++) {
            int listValue = Integer.parseInt(st.nextToken());

            if (listValue == 1) deque.addFirst(i);
            else if (listValue == 2) {
                int tmp = deque.removeFirst();
                deque.addFirst(i);
                deque.addFirst(tmp);
            }
            else {
                deque.addLast(i);
            }
        }

        while (!deque.isEmpty()) {
            bw.write(Integer.toString(deque.poll()) + " ");
        }
        bw.flush();
    }
}
