import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] orders = new String[N];
        for (int i = 0; i < N; i++) orders[i] = br.readLine();

        solve(orders);
        br.close();
    }

    public static void solve(String[] orders) {
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (String order : orders) {
            String[] split = order.split(" ");

            switch (split[0]) {
                case "push":
                    deque.add(Integer.parseInt(split[1]));
                    break;
                case "pop":
                    sb.append(deque.isEmpty() ? -1 : deque.poll()).append('\n');
                    break;
                case "size":
                    sb.append(deque.size()).append('\n');
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append('\n');
                    break;
                default:
                    sb.append(deque.isEmpty() ? -1 : deque.getLast()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }
}
