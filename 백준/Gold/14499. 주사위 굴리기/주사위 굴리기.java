import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final Integer BOTTOM = 0, EAST = 1, WEST = 2, SOUTH = 3, NORTH = 4, TOP = 5;

    static int N, M, x, y, K;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] commands;
    static int[] dice = new int[6];
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        commands = new int[K];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            commands[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < K; i++) {
            int command = commands[i];

            int nx = x + dx[command - 1];
            int ny = y + dy[command - 1];

            if (!valid(nx, ny)) {
                continue;
            }

            move(command);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[BOTTOM];
            } else {
                dice[BOTTOM] = map[nx][ny];
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;
            System.out.println(dice[TOP]);
        }
    }

    public static void move(int command) {
        if (command == EAST) {
            int tmp = dice[EAST];
            dice[EAST] = dice[TOP];
            dice[TOP] = dice[WEST];
            dice[WEST] = dice[BOTTOM];
            dice[BOTTOM] = tmp;
        } else if (command == WEST) {
            int tmp = dice[WEST];
            dice[WEST] = dice[TOP];
            dice[TOP] = dice[EAST];
            dice[EAST] = dice[BOTTOM];
            dice[BOTTOM] = tmp;
        } else if (command == SOUTH) {
            int tmp = dice[SOUTH];
            dice[SOUTH] = dice[TOP];
            dice[TOP] = dice[NORTH];
            dice[NORTH] = dice[BOTTOM];
            dice[BOTTOM] = tmp;
        } else if (command == NORTH) {
            int tmp = dice[NORTH];
            dice[NORTH] = dice[TOP];
            dice[TOP] = dice[SOUTH];
            dice[SOUTH] = dice[BOTTOM];
            dice[BOTTOM] = tmp;
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
