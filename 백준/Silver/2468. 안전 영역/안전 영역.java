import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int maxHigh;
    static int[][] map;
    static int result = 1;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHigh = Math.max(maxHigh, map[i][j]);
            }
        }

        solve();
    }

    public static void solve() {
        for (int i = 0; i <= maxHigh; i++) {
            visit = new boolean[N][N];
            check(i);

            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visit[j][k]) {
                        BFS(k, j);
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.print(result);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visit[cur[1]][cur[0]]) continue;
            visit[cur[1]][cur[0]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[ny][nx]) continue;

                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static void check(int weight) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= weight) visit[i][j] = true;
            }
        }
    }
}
