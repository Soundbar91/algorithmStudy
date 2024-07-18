import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int M, N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        int noRipeTomato = 0;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) list.add(new int[]{i, j});
                else if (map[i][j] == 0) noRipeTomato++;
            }
        }

        if (noRipeTomato == 0) System.out.print(0);
        else System.out.print(solve(list, noRipeTomato));

        br.close();
    }

    public static int solve(List<int[]> list, int noRipeTomato) {
        Queue<int[]> queue = new LinkedList<>(list);
        int day = 0;

        while (!queue.isEmpty()) {
            day++;
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dx[i];
                    int y = cur[1] + dy[i];

                    if (!valid(x, y) || map[x][y] != 0) continue;
                    map[x][y] = map[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{x, y});
                    noRipeTomato--;
                }
            }
        }

        return noRipeTomato == 0 ? day - 1 : -1;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
