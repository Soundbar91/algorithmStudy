import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] picture;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picture = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                picture[i][j] = input.charAt(j);
            }
        }

        int noBlindness = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfsNoBlindness(i, j);
                    noBlindness++;
                }
            }
        }

        int blindness = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfsBlindness(i, j);
                    blindness++;
                }
            }
        }

        System.out.print(noBlindness + " " + blindness);
        br.close();
    }

    public static void bfsNoBlindness(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || visited[nx][ny] || picture[nx][ny] != picture[cur[0]][cur[1]]) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static void bfsBlindness(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!valid(nx, ny) || visited[nx][ny] || !blindness(cur[0], cur[1], nx, ny)) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static boolean blindness(int x1, int y1, int x2, int y2) {
        if (picture[x1][y1] == 'R' && (picture[x2][y2] == 'G' || picture[x2][y2] == 'R')) return true;
        if (picture[x1][y1] == 'G' && (picture[x2][y2] == 'R' || picture[x2][y2] == 'G')) return true;
        if (picture[x1][y1] == 'B' && picture[x2][y2] == 'B') return true;
        return false;
    }
}
