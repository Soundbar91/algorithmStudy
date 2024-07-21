import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0, time = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) result++;
            }
        }


        while (true) {
            List<int[]> list = check();
            melt(list);
            int count = find();
            time++;
            if (count == 0) break;
            else result = count;
        }

        System.out.print(time + "\n" + result);
        br.close();
    }

    public static List<int[]> check() {
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int x = cur[0] + dx[i];
                int y = cur[1] + dy[i];

                if (!valid(x, y) || visited[x][y]) continue;

                if (map[x][y] == 1) list.add(new int[]{x, y});
                else queue.add(new int[]{x, y});
            }
        }

        return list;
    }

    public static void melt(List<int[]> list) {
        for (int[] cheeses : list) map[cheeses[0]][cheeses[1]] = 0;
    }

    public static int find() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count += bfs(i, j, visited);
                }
            }
        }

        return count;
    }

    public static int bfs(int x, int y, boolean[][] visited) {
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;
                queue.add(new int[]{nx, ny});
            }
        }

        return count;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
