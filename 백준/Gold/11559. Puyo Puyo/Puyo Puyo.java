import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static final Integer R = 12, C = 6, STANDARD = 4;

    static boolean flag = false;
    static int result = 0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        while (true) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != '.') {
                        explosion(i, j, map[i][j]);
                    }
                }
            }

            if (!flag) {
                break;
            } else {
                move();
                result++;
                flag = false;
            }
        }
        System.out.print(result);
    }

    public static void explosion(int x, int y, char mark) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> puyos = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(new int[] {x, y});
        puyos.add(new int[] {x, y});
        visited[x][y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!isValid(nx, ny) || visited[nx][ny] || map[nx][ny] != mark) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new int[] {nx, ny});
                puyos.add(new int[] {nx, ny});
            }
        }

        if (count >= STANDARD) {
            flag = true;
            for (int i = 0; i < puyos.size(); i++) {
                int[] puyo = puyos.get(i);
                map[puyo[0]][puyo[1]] = '.';
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    public static void move() {
        for (int i = 0; i < C; i++) {
            for (int j = R - 1; j >= 0; j--) {
                if (map[j][i] == '.' && checkPuyo(j, i)) {
                    moveMap(j, i);
                }
            }
        }
    }

    public static boolean checkPuyo(int x, int y) {
        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] != '.') {
                return true;
            }
        }
        return false;
    }

    public static void moveMap(int x, int y) {
        int index = x;

        for (int i = x - 1; i >= 0; i--) {
            if (map[i][y] != '.') {
                map[index][y] = map[i][y];
                map[i][y] = '.';
                index--;
            }
        }
    }
}
