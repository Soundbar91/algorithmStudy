import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M, H, W, Sr, Sc, Fr, Fc;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> coordinates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][M + 1];

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) coordinates.add(new int[]{i, j});
            }
        }

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        Sr = Integer.parseInt(st.nextToken());
        Sc = Integer.parseInt(st.nextToken());
        Fr = Integer.parseInt(st.nextToken());
        Fc = Integer.parseInt(st.nextToken());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{Sr, Sc});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == Fr && cur[1] == Fc) return map[cur[0]][cur[1]];

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if (!valid(x, y) || visited[x][y]) continue;
                if (check(x, y)) {
                    map[x][y] = map[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }

        return -1;
    }

    public static boolean valid(int x, int y) {
        return (x > 0 && x <= N && y > 0 && y <= M) && (x + H - 1 <= N && y + W - 1 <= M);
    }

    public static boolean check(int x, int y) {
        for (int[] coordinate : coordinates) {
            if (coordinate[0] >= x && coordinate[0] <= x + H - 1
                    && coordinate[1] >= y && coordinate[1] <= y + W - 1)
                return false;
        }

        return true;
    }
}
