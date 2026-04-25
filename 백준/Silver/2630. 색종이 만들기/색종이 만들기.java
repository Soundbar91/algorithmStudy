import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int blue;    // 1
    static int white;   // 0
    static int[][] map;

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

        solved(N, 0, 0);
        System.out.print(white + "\n" + blue);
    }

    public static void solved(int size, int x, int y) {
        if (!valid(x, y, size)) {
            int n = size / 2;
            solved(n, x, y);
            solved(n, x + n, y);
            solved(n, x, y + n);
            solved(n, x + n, y + n);
        }
        else {
            if (map[y][x] == 0) white++;
            else blue++;
        }
    }

    public static boolean valid(int x, int y, int size) {
        int color = map[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
