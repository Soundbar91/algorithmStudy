import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static List<int[]> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        createWall(3);
        System.out.print(result);
        br.close();
    }

    public static void createWall(int wall) {
        if (wall == 0) bfs();
        else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        createWall(wall - 1);
                        map[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void bfs() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++)
            System.arraycopy(map[i], 0, copyMap[i], 0, M);

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>(virus);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || visited[nx][ny] || copyMap[nx][ny] == 1) continue;
                copyMap[nx][ny] = 2;
                queue.add(new int[]{nx, ny});
            }
        }

        check(copyMap);
    }

    public static void check(int[][] map) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) count++;
            }
        }

        result = Math.max(result, count);
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
