import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, L, R, day, index;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] union;
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

        while (solve()) {
            movePeople();
            day++;
        }

        System.out.print(day);
        br.close();
    }

    public static boolean solve() {
        union = new int[N][N];
        visited = new boolean[N][N];
        index = 1;
        boolean update = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j, index)) {
                        update = true;
                        index++;
                    }
                    else union[i][j] = 0;
                }
            }
        }

        return update;
    }

    public static boolean bfs(int x, int y, int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        union[x][y] = index;
        boolean update = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (visited[cur[0]][cur[1]]) continue;
            visited[cur[0]][cur[1]] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || visited[nx][ny]) continue;

                int value = Math.abs(map[nx][ny] - map[cur[0]][cur[1]]);
                if (value >= L && value <= R) {
                    update = true;
                    union[nx][ny] = index;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return update;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void movePeople() {
        List<List<int[]>> unionLists = new ArrayList<>();
        for (int i = 0; i < index; i++) unionLists.add(new ArrayList<>());

        int[] total = new int[index];
        for (int i = 1; i < index; i++) {
            int sum = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (union[j][k] == i) {
                        unionLists.get(i).add(new int[]{j, k});
                        sum += map[j][k];
                    }
                }
            }
            total[i] = sum / unionLists.get(i).size();
        }

        for (int i = 1; i < index; i++) {
            List<int[]> unionList = unionLists.get(i);

            for (int[] union : unionList) {
                int x = union[0];
                int y = union[1];

                map[x][y] = total[i];
            }
        }
    }
}
