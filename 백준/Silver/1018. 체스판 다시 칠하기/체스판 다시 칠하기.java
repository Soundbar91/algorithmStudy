import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = 987654321;
    static int[][] map;
    static int[][] whiteMap = {
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1}
    };
    static int[][] blackMap = {
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0},
        {0, 1, 0, 1, 0, 1, 0, 1},
        {1, 0, 1, 0, 1, 0, 1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == 'W') {
                    map[i][j + 1] = 1;
                } else {
                    map[i][j + 1] = 0;
                }
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 8; i <= N; i++) {
            for (int j = 8; j <= M; j++) {
                check(i, j);
            }
        }
        System.out.print(result);
    }

    public static void check(int x, int y) {
        int white = 0;
        int black = 0;

        for (int i = x; i > x - 8; i--) {
            for (int j = y; j > y - 8; j--) {
                if (map[i][j] != whiteMap[(i - 1) % 8][(j - 1) % 8]) white++;
                if (map[i][j] != blackMap[(i - 1) % 8][(j - 1) % 8]) black++;
            }
        }

        result = Math.min(result, Math.min(white, black));
    }
}
