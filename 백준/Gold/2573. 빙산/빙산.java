import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, day;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static int[][] penalty;
    static boolean[][] visited;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        penalty = new int[N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) list.add(new int[]{i, j});
            }
        }

        init();

        while (!check() && !list.isEmpty()) {
            List<int[]> removes = solve();
            reset(removes);
            day++;
        }

        System.out.print(list.isEmpty() ? 0 : day);
        br.close();
    }

    public static void init() {
        for (int[] into : penalty) Arrays.fill(into, -1);

        for (int[] cur : list) {
            int count = 0;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i], ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] == 0) count++;
            }

            penalty[cur[0]][cur[1]] = count;
        }
    }

    public static List<int[]> solve() {
        List<int[]> removes = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int[] ice = list.get(i);

            map[ice[0]][ice[1]] -= penalty[ice[0]][ice[1]];
            if (map[ice[0]][ice[1]] <= 0) {
                list.remove(i);
                i--;
                map[ice[0]][ice[1]] = 0;
                removes.add(new int[]{ice[0], ice[1]});
            }
        }

        return removes;
    }

    public static void reset(List<int[]> removes) {
        for (int[] remove : removes) {
            for (int i = 0; i < 4; i++) {
                int nx = remove[0] + dx[i], ny = remove[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (penalty[nx][ny] != -1) penalty[nx][ny]++;
            }
        }
    }

    public static boolean check() {
        int count = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(i, j);
                    if (++count == 2) return true;
                }
            }
        }

        return false;
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k], ny = cur[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                queue.add(new int[]{nx, ny});
            }
        }
    }
}
