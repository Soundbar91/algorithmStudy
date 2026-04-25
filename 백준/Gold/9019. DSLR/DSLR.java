import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.print(sb);
    }

    public static void bfs(int A, int B) {
        Queue<Value> queue = new LinkedList<>();
        boolean[] visited = new boolean[10000];
        queue.add(new Value(A, ""));
        visited[A] = true;

        while (!queue.isEmpty()) {
            Value value = queue.poll();

            if (value.value == B) {
                sb.append(value.order).append('\n');
                return ;
            }

            int D = (2 * value.value) % 10000;
            if (!visited[D]) {
                visited[D] = true;
                queue.add(new Value(D, value.order + "D"));
            }

            int S = value.value == 0 ? 9999 : value.value - 1;
            if (!visited[S]) {
                visited[S] = true;
                queue.add(new Value(S, value.order + "S"));
            }

            int L = (value.value % 1000) * 10 + value.value / 1000;
            if (!visited[L]) {
                visited[L] = true;
                queue.add(new Value(L, value.order + "L"));
            }

            int R = (value.value % 10) * 1000 + value.value / 10;
            if (!visited[R]) {
                visited[R] = true;
                queue.add(new Value(R, value.order + "R"));
            }
        }

    }

    public static class Value {
        int value;
        String order;

        public Value(int value, String order) {
            this.value = value;
            this.order = order;
        }
    }
}
