import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'I') {
                    x = j;
                    y = i;
                }
                map[i][j] = str.charAt(j);
            }
        }


        solve(x, y);
        System.out.print(result != 0 ? result : "TT");
        br.close();
    }

    public static void solve(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        map[y][x] = 'X';

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ux = node[0] + dx[i];
                int uy = node[1] + dy[i];

                if (!valid(ux, uy) || map[uy][ux] == 'X') continue;
                if (map[uy][ux] == 'P') result++;

                map[uy][ux] = 'X';
                queue.add(new int[]{ux, uy});
            }
        }
    }

    public static boolean valid(int x, int y) {
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}
