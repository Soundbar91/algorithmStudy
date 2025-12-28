import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, bx, by, rx, ry, ox, oy, result = 987654321;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (map[i][j] == 'O') {
                    ox = i;
                    oy = j;
                }
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < 4; i++) {
            play(i, bx, by, rx, ry, 1);
        }
        System.out.print(result == 987654321 ? -1 : result);
    }

    public static void play(int mode, int bx, int by, int rx, int ry, int count) {
        if (count > 10) return;

        int nbx = bx, nby = by, nrx = rx, nry = ry;

        while (map[nbx + dx[mode]][nby + dy[mode]] != '#' && map[nbx][nby] != 'O') {
            nbx += dx[mode];
            nby += dy[mode];
        }

        while (map[nrx + dx[mode]][nry + dy[mode]] != '#' && map[nrx][nry] != 'O') {
            nrx += dx[mode];
            nry += dy[mode];
        }

        if (map[nbx][nby] == 'O') {
            return;
        }

        if (map[nrx][nry] == 'O') {
            result = Math.min(result, count);
            return;
        }

        if (nbx == nrx && nby == nry) {
            if (mode == 0) {
                if (ry > by) nby--;
                else nry--;
            } else if (mode == 1) {
                if (ry < by) nby++;
                else nry++;
            } else if (mode == 2) {
                if (rx > bx) nbx--;
                else nrx--;
            } else if (mode == 3) {
                if (rx < bx) nbx++;
                else nrx++;
            }
        }

        for (int i = 0; i < 4; i++) {
            play(i, nbx, nby, nrx, nry, count + 1);
        }
    }
}
