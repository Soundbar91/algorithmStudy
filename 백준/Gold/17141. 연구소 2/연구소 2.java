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
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> nums = new ArrayList<>();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    nums.add(new int[] {i, j});
                }
            }
        }

        check = new boolean[nums.size()];
        permutation(0, 0, new ArrayList<>());

        System.out.print(result == 987654321 ? -1 : result);
        br.close();
    }

    public static void permutation(int count, int start, List<int[]> point) {
        if (count == M) {
            int time = bfs(point);
            if (solve()) result = Math.min(result, time);
            return ;
        }

        for (int i = start; i < check.length; i++) {
            point.add(count, nums.get(i));
            permutation(count + 1, i + 1, point);
            point.remove(point.size() - 1);
        }
    }

    public static int bfs(List<int[]> canPoint) {
        visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        for (int[] cur : canPoint) {
            queue.add(cur);
            visited[cur[0]][cur[1]] = true;
        }

        int time = 0;

        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = cur[0] + dx[j];
                    int ny = cur[1] + dy[j];

                    if (!valid(nx, ny) || visited[nx][ny] || map[nx][ny] == 1) continue;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }

            if (!queue.isEmpty()) time++;
        }

        return time;
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1 && !visited[i][j]) return false;
            }
        }
        return true;
    }
}
