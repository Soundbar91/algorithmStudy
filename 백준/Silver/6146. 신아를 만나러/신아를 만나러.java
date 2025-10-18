import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int X, Y, N;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map = new int[1_001][1_001];
    static boolean[][] visited = new boolean[1_001][1_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[500 + x][500 + y] = 1;
        }

        solve();
        br.close();
    }

    public static void solve() {
        System.out.print(bfs());
    }

    public static Integer bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(500, 500, 0));
        visited[500][500] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == X + 500 && cur.y == Y + 500) {
                return cur.weight;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!valid(nx, ny) || map[nx][ny] == 1 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.add(new Node(nx, ny, cur.weight + 1));
            }
        }

        return -1;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < 1_001 && y >= 0 && y < 1_001;
    }

    public static class Node {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
