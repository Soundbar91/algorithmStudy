import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int minusCount;
    static int zeroCount;
    static int plusCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(N, 0, 0);
        System.out.print(minusCount + "\n" + zeroCount + "\n" + plusCount);
    }

    public static void solve(int size, int x, int y) {
        if (!valid(x, y, size)) {
            int n = size / 3;
            solve(n, x, y);
            solve(n, x + n, y);
            solve(n, x + (n * 2), y);
            solve(n, x, y + n);
            solve(n, x + n, y + n);
            solve(n, x + (n * 2), y + n);
            solve(n, x, y + (n * 2));
            solve(n, x + n, y + (n * 2));
            solve(n, x + (n * 2), y + (n * 2));
        }
        else {
            if (map[y][x] == 0) zeroCount++;
            else if (map[y][x] == 1) plusCount++;
            else minusCount++;
        }
    }

    public static boolean valid(int x, int y, int size) {
        int paper = map[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != paper) {
                    return false;
                }
            }
        }
        return true;
    }
}
