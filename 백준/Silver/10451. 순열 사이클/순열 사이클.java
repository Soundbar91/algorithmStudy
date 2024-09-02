import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            visited = new boolean[N + 1];

            graph.clear();
            for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int to = Integer.parseInt(st.nextToken());

                graph.get(i).add(to);
            }

            int result = 0;

            for (int i = 1; i <= N; i++) {
                if (solve(i)) result++;
            }

            System.out.println(result);
        }

        br.close();
    }

    public static boolean solve(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (visited[cur]) continue;
            visited[cur] = true;

            for (int i : graph.get(cur)) {
                if (i == start) return true;
                if (!visited[i]) stack.push(i);
            }
        }

        return false;
    }
}
