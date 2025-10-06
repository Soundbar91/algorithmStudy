import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;  // 세로
    static int M;  // 가로
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] brokenMap;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        brokenMap = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        solve();
    }

    public static void solve() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, false));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.print(cur.weight);
                return ;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!valid(nx, ny)) continue;

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny] && !cur.broken) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, cur.weight + 1, false));
                    }
                    else if (!brokenMap[nx][ny] && cur.broken) {
                        brokenMap[nx][ny] = true;
                        queue.add(new Node(nx, ny, cur.weight + 1, true));
                    }
                }
                else if (map[nx][ny] == 1) {
                    if (!cur.broken) {
                        brokenMap[nx][ny] = true;
                        queue.add(new Node(nx, ny, cur.weight + 1, true));
                    }
                }
            }
        }
        System.out.print(-1);
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static class Node {
        int x;
        int y;
        int weight;
        boolean broken;

        public Node(int x, int y, int weight, boolean broken) {
            this.x = x;
            this.y = y;
            this.weight = weight;
            this.broken = broken;
        }
    }
}
