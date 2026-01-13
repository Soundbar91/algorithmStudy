import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dist;
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            for (int j = 1; j < count; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(prev).add(next);
                dist[next]++;
                prev = next;
            }
        }

        if (hasCycle()) {
            System.out.print(0);
            return;
        }

        solve();
        br.close();
    }

    public static boolean hasCycle() {
        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                if (dfs(i)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int node) {
        if (visited[node] == 1) {
            return true;
        }

        if (visited[node] == 2) {
            return false;
        }

        visited[node] = 1;

        for (int next : graph.get(node)) {
            if (dfs(next)) {
                return true;
            }
        }

        visited[node] = 2;
        return false;
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append('\n');

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                dist[next]--;

                if (dist[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.print(sb);
    }
}