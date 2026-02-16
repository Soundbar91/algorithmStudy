import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r;
    static int[] items;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        dist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            dist[i][i] = 0;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            dist[a][b] = r;
            dist[b][a] = r;
        }

        solve();
        br.close();
    }

    public static void solve() {
        floydWarshall();
        int result = -1;

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, bfs(i));
        }

        System.out.print(result);
    }

    public static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        int count = items[start];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (dist[cur[0]][i] != Integer.MAX_VALUE / 2) {
                    if (!visited[i] && m >= cur[1] + dist[cur[0]][i]) {
                        visited[i] = true;
                        queue.offer(new int[]{i, cur[1] + dist[cur[0]][i]});
                        count += items[i];
                    }
                }
            }
        }

        return count;
    }
}
