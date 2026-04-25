import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        solve(0, 0, N, map);
        System.out.print(sb);
    }

    public static void solve(int x, int y, int size, int[][] map) {
        if (!valid(x, y, size, map)) {
            sb.append('(');
            int n = size / 2;
            solve(x, y, n, map);
            solve(x + n, y, n, map);
            solve(x, y + n, n, map);
            solve(x + n, y + n, n, map);
            sb.append(')');
        }
        else {
            sb.append(map[y][x]);
        }
    }

    public static boolean valid(int x, int y, int size, int[][] map) {
        int color = map[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (color != map[i][j]) return false;
            }
        }

        return true;
    }
}
