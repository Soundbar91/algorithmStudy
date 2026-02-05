import java.io.*;
import java.util.*;

public class Main {

    static int N, result, root, removeNodeIndex;
    static boolean[] visited;
    static List<List<Integer>> graph = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());

            if (parent == -1) {
                root = i;
                continue;
            }

            graph.get(parent).add(i);
            graph.get(i).add(parent);
        }

        removeNodeIndex = Integer.parseInt(br.readLine());

        solve();
        br.close();
    }

    public static void solve() {
        if (removeNodeIndex == root) {
            System.out.print(0);
            return ;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[root] = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int count = 0;

            for (int next : graph.get(cur)) {
                if (visited[next]) {
                    continue;
                }
                if (next == removeNodeIndex) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);
                count++;
            }

            if (count == 0) {
                result++;
            }
        }

        System.out.print(result);
    }
}
