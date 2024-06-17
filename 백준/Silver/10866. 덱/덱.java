import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] orders = new String[N];
        for (int i = 0; i < N; i++) orders[i] = br.readLine();

        solve(orders);
        br.close();
    }

    public static void solve( String[] orders) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (String order : orders) {
            String[] split = order.split(" ");

            switch (split[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(split[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(split[1]));
                    break;
                case "pop_front":
                    System.out.println(deque.isEmpty() ? -1 : deque.removeFirst());
                    break;
                case "pop_back":
                    System.out.println(deque.isEmpty() ? -1 : deque.removeLast());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(deque.isEmpty() ? -1 : deque.peekFirst());
                    break;
                default:
                    System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
                    break;
            }
        }
    }
}
