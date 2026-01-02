import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, M, result = 987654321;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + M + 1];
        for (int i = 0; i < N + M + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int cur = Integer.parseInt(st.nextToken());
                graph.get(cur).add(N + i);
                graph.get(N + i).add(cur);
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        dfs();
        System.out.print(result == 987654321 ? -1 : result);
    }

    public static void dfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 1});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == N) {
                result = Math.min(result, cur[1]);
                break;
            }

            for (int i = 0; i < graph.get(cur[0]).size(); i++) {
                if (!visited[graph.get(cur[0]).get(i)]) {
                    visited[graph.get(cur[0]).get(i)] = true;
                    if (graph.get(cur[0]).get(i) > N) {
                        queue.add(new int[] {graph.get(cur[0]).get(i), cur[1]});
                    }
                    else {
                        queue.add(new int[] {graph.get(cur[0]).get(i), cur[1] + 1});
                    }
                }
            }
        }
    }
}