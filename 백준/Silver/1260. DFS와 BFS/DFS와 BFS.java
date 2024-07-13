import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, V;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) list.get(i).sort(null);

        dfs();
        sb.append('\n');
        visited = new boolean[N + 1];
        bfs();
        System.out.print(sb);
        br.close();
    }

    public static void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(V);

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (visited[cur]) continue;
            visited[cur] = true;
            sb.append(cur).append(" ");

            List<Integer> next = list.get(cur);

            for (int i = next.size() - 1; i >= 0; i--) {
                if (!visited[next.get(i)]) stack.push(next.get(i));
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            sb.append(cur).append(" ");

            for (int next : list.get(cur)) {
                if (!visited[next]) queue.add(next);
            }
        }
    }
}
