import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, r, c, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        bfs();
        System.out.print(countByCleanPoint());
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            if (map[x][y] == 0) {
                visited[x][y] = true;
            }

            if (isCanClean(x, y)) {
                turn();
                
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (valid(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new int[] {nx, ny});
                } else {
                    queue.add(new int[] {x, y});
                }
            } else {
                int nx = x - dx[d];
                int ny = y - dy[d];

                if (!valid(nx, ny) || map[nx][ny] == 1) {
                    break;
                } else {
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }

    public static boolean isCanClean(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!valid(nx, ny)) {
                continue;
            }

            if (map[nx][ny] == 0 && !visited[nx][ny]) {
                return true;
            }
        }

        return false;
    }

    public static void turn() {
        if (d == 0) {
            d = 3;
        } else if (d == 1) {
            d = 0;
        } else if (d == 2) {
            d = 1;
        } else if (d == 3) {
            d = 2;
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static int countByCleanPoint() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
