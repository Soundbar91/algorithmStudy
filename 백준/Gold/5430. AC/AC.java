import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            deque = new ArrayDeque<>();
            String p = br.readLine();
            n = Integer.parseInt(br.readLine());

            String array = br.readLine();
            String[] split = array.substring(1, array.length() - 1).split(",");

            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(split[i]));
            }

            solve(p);
        }

        System.out.print(sb);
        br.close();
    }

    public static void solve(String p) {
        boolean isFirst = true;

        for (int i = 0; i < p.length(); i++) {
            char command = p.charAt(i);

            if (command == 'D') {
                if (deque.isEmpty()) {
                    sb.append("error").append('\n');
                    return;
                } else {
                    if (isFirst) {
                        deque.pollFirst();
                    } else {
                        deque.pollLast();
                    }
                }
            } else {
                isFirst = !isFirst;
            }
        }

        sb.append('[');
        while (!deque.isEmpty()) {
            if (isFirst) {
                sb.append(deque.pollFirst());
            } else {
                sb.append(deque.pollLast());
            }

            if (!deque.isEmpty()) {
                sb.append(',');
            }
        }
        sb.append(']').append('\n');
    }
}
