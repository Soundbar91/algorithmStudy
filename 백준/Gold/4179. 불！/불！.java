import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] maze;
    static int[][] jihoon;
    static int[][] fire;
    static Queue<JiHoon> jiHoonQueue = new LinkedList<>();
    static Queue<Fire> fireQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        maze = new char[R][C];
        jihoon = new int[R][C];
        fire = new int[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(jihoon[i], -1);
            Arrays.fill(fire[i], -1);
        }

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                maze[i][j] = input.charAt(j);
                if (maze[i][j] == 'J') {
                    jiHoonQueue.add(new JiHoon(i, j, 0));
                    jihoon[i][j] = 0;
                }
                if (maze[i][j] == 'F') {
                    fireQueue.add(new Fire(i, j, 0));
                    fire[i][j] = 0;
                }
            }
        }

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        fireBfs();
        return jihoonBfs();
    }

    public static void fireBfs() {
        while (!fireQueue.isEmpty()) {
            Fire cur = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!valid(nx, ny) || maze[nx][ny] == '#' || fire[nx][ny] >= 0) continue;
                fire[nx][ny] = fire[cur.x][cur.y] + 1;
                fireQueue.add(new Fire(nx, ny, cur.time + 1));
            }
        }
    }

    public static String jihoonBfs() {
        while (!jiHoonQueue.isEmpty()) {
            JiHoon cur = jiHoonQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!valid(nx, ny)) {
                    return String.valueOf(cur.time + 1);
                }

                if (maze[nx][ny] != '.' || jihoon[nx][ny] != -1 || (fire[nx][ny] != -1 && fire[nx][ny] <= jihoon[cur.x][cur.y] + 1)) continue;
                jihoon[nx][ny] = jihoon[cur.x][cur.y] + 1;
                jiHoonQueue.add(new JiHoon(nx, ny, cur.time + 1));
            }
        }

        return "IMPOSSIBLE";
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static class JiHoon {
        int x;
        int y;
        int time;

        public JiHoon(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static class Fire {
        int x;
        int y;
        int time;

        public Fire(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
