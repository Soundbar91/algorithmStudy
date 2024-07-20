import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, L, R;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static List<int[]> list;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean move = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            move = true;
                            movePeople(sum);
                        }
                    }
                }
            }

            if (!move) return day;
            day++;
        }
    }

    public static int bfs(int x, int y) {
        list = new ArrayList<>();
        list.add(new int[]{x, y});
        int sum = map[x][y];
        visited[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || visited[nx][ny]) continue;

                int value = Math.abs(map[nx][ny] - map[cur[0]][cur[1]]);
                if (value >= L && value <= R) {
                    queue.add(new int[]{nx, ny});
                    list.add(new int[]{nx, ny});
                    sum += map[nx][ny];
                    visited[nx][ny] = true;
                }
            }
        }

        return sum;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void movePeople(int sum) {
        int people = sum / list.size();
        for (int[] country : list) map[country[0]][country[1]] = people;
    }
}
