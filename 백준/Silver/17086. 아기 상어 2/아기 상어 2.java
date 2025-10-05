import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = -1;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] board;
    static boolean[][] visited;
    static List<int[]> shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        shark = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    shark.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    visited = new boolean[N][M];
                    result = Math.max(result, bfs(i, j));
                }
            }
        }

        System.out.print(result);
        br.close();
    }

    public static int bfs(int x, int y) {
        Queue<Block> queue = new LinkedList<>();
        queue.add(new Block(x, y, 0));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Block cur = queue.poll();

            if (board[cur.x][cur.y] == 1) {
                return cur.dist;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!valid(nx, ny) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Block(nx, ny, cur.dist + 1));
            }
        }

        return -1;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Block {
        int x;
        int y;
        int dist;

        public Block(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
