import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Deque<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push")) {
                queue.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("size")) {
                System.out.println(queue.size());
            } else if (command.equals("empty")) {
                System.out.println(queue.isEmpty() ? 1 : 0);
            } else if (command.equals("front")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.peek());
                } else {
                    System.out.println(-1);
                }
            } else if (command.equals("back")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.getLast());
                } else {
                    System.out.println(-1);
                }
            }
        }

        br.close();
    }
}
