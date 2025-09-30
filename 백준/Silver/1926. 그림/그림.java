import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, cnt, size = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] picture;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        picture = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && picture[i][j] == 1) {
                    size = Math.max(size, bfs(i, j));
                    cnt++;
                }
            }
        }

        System.out.print(cnt + "\n" + size);
        br.close();
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            size++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || visited[nx][ny] || picture[nx][ny] == 0) continue;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        return size;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
