import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] tomato;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) queue.add(new int[]{i, j});
            }
        }

        System.out.print(bfs());
        br.close();
    }

    public static int bfs() {
        int day = 0;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (!valid(nx, ny) || tomato[nx][ny] != 0) continue;
                    queue.add(new int[]{nx, ny});
                    tomato[nx][ny] = 1;
                }
            }
            if (!queue.isEmpty()) day++;
        }

        return searchZero() ? -1 : day;
    }

    public static boolean searchZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
