import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int M, N, H;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        int noRipeTomato = 0;

        map = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) list.add(new int[]{i, j, k});
                    else if (map[i][j][k] == 0) noRipeTomato++;
                }
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

                for (int i = 0; i < 6; i++) {
                    int x = cur[0] + dx[i];
                    int y = cur[1] + dy[i];
                    int z = cur[2] + dz[i];

                    if (!valid(x, y, z) || map[x][y][z] != 0) continue;
                    map[x][y][z] = map[cur[0]][cur[1]][cur[2]] + 1;
                    queue.add(new int[]{x, y, z});
                    noRipeTomato--;
                }
            }
        }

        return noRipeTomato == 0 ? day - 1 : -1;
    }

    public static boolean valid(int x, int y, int z) {
        return x >= 0 && x < H && y >= 0 && y < N && z >= 0 && z < M;
    }
}
