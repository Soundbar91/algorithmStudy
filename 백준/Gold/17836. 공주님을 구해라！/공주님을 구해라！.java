import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, T;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        int result = 987654321;

        Queue<Player> queue = new LinkedList<>();
        queue.add(new Player(0, 0, 0));

        while (!queue.isEmpty()) {
            Player cur = queue.poll();
            if (cur.time > T) continue;

            if (cur.x == N - 1 && cur.y == M - 1) {
                result = Math.min(result, cur.time);
                continue;
            }

            if (visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;

            if (map[cur.x][cur.y] == 2) {
                int nx = (N - 1) - cur.x;
                int ny = (M - 1) - cur.y;
                int time = cur.time + nx + ny;
                if (time > T) continue;
                else result = Math.min(result, time);
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!valid(nx, ny) || visited[nx][ny] || map[nx][ny] == 1) continue;

                queue.add(new Player(nx, ny, cur.time + 1));
            }
        }

        return result == 987654321 ? "Fail" : String.valueOf(result);
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Player {
        int x;
        int y;
        int time;

        public Player(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
