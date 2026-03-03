import java.io.*;
import java.util.*;

/**
 * 한 섬과 다른 섬을 잇는 다리 하나만 생성, 가장 짧게 만듦
 *
 * 섬 번호를 인덱싱
 * 상하좌우가 모두 섬인 경우에는 continue
 * 그렇지 않은 경우에는 해당 좌표에서 탐색
 * 탐색하는 과정에서 다른 섬을 찾기
 */

public class Main {

    static int N, result = 987654321;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        indexing();
        find();
        System.out.print(result);
    }

    public static void indexing() {
        visited = new boolean[N][N];
        int index = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    map[i][j] = index;
                    bfsForIndexing(i, j, index++);
                }
            }
        }
    }

    public static void bfsForIndexing(int x, int y, int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                map[nx][ny] = index;
                queue.add(new int[] {nx, ny});
            }
        }
    }

    public static void find() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && isEqual(i, j)) {
                    visited[i][j] = true;
                    bfs(map[i][j], i, j);
                }
            }
        }
    }

    public static void bfs(int index, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        visited = new boolean[N][N];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != index) {
                result = Math.min(result, cur[2] - 1);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || map[nx][ny] == index || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny,  cur[2] + 1});
            }
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean isEqual(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!valid(nx, ny)) {
                continue;
            }

            if (map[nx][ny] == 0) {
                return true;
            }
        }

        return false;
    }
}
