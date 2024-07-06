import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result = -1;
    static boolean[] visited;
    static int[][] map;
    static int[][] dx = {
            {0, -1},
            {0, -1},
            {0, 1},
            {0, 1}
    };
    static int[][] dy = {
            {-1, 0},
            {1, 0},
            {-1, 0},
            {1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N * M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (N <= 1 || M <= 1) {
            System.out.print(0);
            System.exit(0);
        }

        solve(0, 0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int depth, int sum) {
        if (depth == N * M) {
            result = Math.max(result, sum);
            return ;
        }
        if (!visited[depth]) {
            visited[depth] = true;

            int x = depth / M;
            int y = depth % M;
            int value = map[x][y] * 2;

            for (int j = 0; j < 4; j++) {
                if (check(x, y, j)) {
                    solve(depth + 1, sum + value + flip(x, y, j, true));
                    flip(x, y, j, false);
                }
            }

            visited[depth] = false;
        }

        solve(depth + 1, sum);
    }

    public static boolean check(int x, int y, int n) {
        for (int i = 0; i < 2; i++) {
            int ux = x + dx[n][i];
            int uy = y + dy[n][i];

            if (!valid(ux, uy) || visited[ux * M + uy]) return false;
        }

        return true;
    }

    public static int flip(int x, int y, int n, boolean status) {
        int value = 0;

        for (int i = 0; i < 2; i++) {
            int ux = x + dx[n][i];
            int uy = y + dy[n][i];

            visited[ux * M + uy] = status;
            value += map[ux][uy];
        }

        return value;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
