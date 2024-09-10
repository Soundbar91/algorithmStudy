import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N, value, x, y;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        value = Integer.parseInt(br.readLine());
        map = new int[N][N];

        solve(0, 0, N * N, 0);
        print();
        br.close();
    }

    public static void solve(int x, int y, int value, int step) {
        map[x][y] = value;

        while (true) {
            if (value == 1) {
                print();
                System.exit(0);
            }

            int ux = x + dx[step];
            int uy = y + dy[step];

            if (!valid(ux, uy) || map[ux][uy] != 0){
                solve(x, y, value, (step + 1) % 4);
            }
            else {
                map[ux][uy] = --value;
                x = x + dx[step];
                y = y + dy[step];
            }
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == value) {
                    x = i + 1;
                    y = j + 1;
                }
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print(x + " " + y);
    }
}
