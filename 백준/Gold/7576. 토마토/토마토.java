import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int M, N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) list.add(new int[]{i, j});
            }
        }

        if (list.size() == N * M) System.out.print(0);
        else {
            bfs(list);
            System.out.print(print());
        }

        br.close();
    }

    public static void bfs(List<int[]> list) {
        Queue<int[]> queue = new LinkedList<>(list);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if (!valid(x, y) || map[x][y] != 0) continue;
                map[x][y] = map[cur[0]][cur[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static int print() {
        int result = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) return -1;
                else result = Math.max(result, map[i][j]);
            }
        }

        return result - 1;
    }
}
