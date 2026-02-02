import java.io.*;
import java.util.*;

public class Main {

    static int n, m, T = 1;
    static int[] parents;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            parents = new int[n + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            solve();
        }

        br.close();
    }

    public static void solve() {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (parents[i] == 0 && bfs(i)) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Case " + T + ": No trees.");
        } else if (count == 1) {
            System.out.println("Case " + T + ": There is one tree.");
        } else {
            System.out.println("Case " + T + ": A forest of " + count + " trees.");
        }
        T++;
    }

    public static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (parents[cur] == next) {
                    continue;
                }
                if (parents[next] != 0) {
                    return false;
                }
                parents[next] = cur;
                queue.add(next);
            }
        }

        return true;
    }
}
