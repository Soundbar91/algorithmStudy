import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result = 987654321;
    static int[] cctvMode;
    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static List<int[]> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0) {
                    if (map[i][j] != 6) {
                        cctvs.add(new int[] {i, j});
                    }
                    visited[i][j] = true;
                }
            }
        }
        cctvMode = new int[cctvs.size()];

        solve();
        br.close();
    }

    public static void solve() {
        permutation(0);
        System.out.print(result);
    }

    public static void permutation(int depth) {
        if (depth == cctvs.size()) {
            copyMap = new int[N][M];

            for (int i = 0; i < N; i++) {
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }

            for (int i = 0; i < cctvs.size(); i++) {
                int[] cctv = cctvs.get(i);
                search(cctv[0], cctv[1], map[cctv[0]][cctv[1]], cctvMode[i]);
            }

            result = Math.min(result, count());
        }
        else {
            for (int i = 0; i < 4; i++) {
                cctvMode[depth] = i;
                permutation( depth + 1);
            }
        }
    }

    public static void search(int x, int y, int serialNumber, int mode) {
        if (serialNumber == 1) {
            if (mode == 0) {
                bfs(x, y, 0);
            }
            else if (mode == 1) {
                bfs(x, y, 1);
            }
            else if (mode == 2) {
                bfs(x, y, 2);
            }
            else if (mode == 3) {
                bfs(x, y, 3);
            }
        } else if (serialNumber == 2) {
            if (mode == 0 || mode == 2) {
                bfs(x, y, 0);
                bfs(x, y, 1);
            } else if (mode == 1 || mode == 3) {
                bfs(x, y, 2);
                bfs(x, y, 3);
            }
        } else if (serialNumber == 3) {
            if (mode == 0) {
                bfs(x, y, 0);
                bfs(x, y, 3);
            } else if (mode == 1) {
                bfs(x, y, 1);
                bfs(x, y, 3);
            } else if (mode == 2) {
                bfs(x, y, 1);
                bfs(x, y, 2);
            } else if (mode == 3) {
                bfs(x, y, 0);
                bfs(x, y, 2);
            }
        } else if (serialNumber == 4){
            if (mode == 0) {
                bfs(x, y, 0);
                bfs(x, y, 2);
                bfs(x, y, 3);
            } else if (mode == 1) {
                bfs(x, y, 0);
                bfs(x, y, 1);
                bfs(x, y, 3);
            } else if (mode == 2) {
                bfs(x, y, 1);
                bfs(x, y, 2);
                bfs(x, y, 3);
            } else if (mode == 3) {
                bfs(x, y, 0);
                bfs(x, y, 1);
                bfs(x, y, 2);
            }
        } else {
            bfs(x, y, 0);
            bfs(x, y, 1);
            bfs(x, y, 2);
            bfs(x, y, 3);
        }
    }

    public static void bfs(int x, int y, int mode) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] cctv = queue.poll();

            int nx = cctv[0] + dx[mode];
            int ny = cctv[1] + dy[mode];

            if (!valid(nx, ny) || copyMap[nx][ny] == 6) {
                continue;
            }

            if (copyMap[nx][ny] == 0) {
                copyMap[nx][ny] = -1;
            }
            queue.add(new int[] {nx, ny});
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    public static int count() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
