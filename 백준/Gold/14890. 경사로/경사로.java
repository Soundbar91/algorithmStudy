import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L, result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            if (searchRow(i)) result++;
            if (searchColumn(i)) result++;
        }
        System.out.print(result);
    }

    public static boolean searchRow(int row) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[row][i] - map[row][i + 1];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || visited[i - j]) return false;
                    if (map[row][i] != map[row][i - j]) return false;
                    visited[i - j] = true;
                }
            }
            else if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || visited[i + j]) return false;
                    if (map[row][i] - 1 != map[row][i + j]) return false;
                    visited[i + j] = true;
                }
            }
        }
        return true;
    }

    public static boolean searchColumn(int column) {
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][column] - map[i + 1][column];

            if (diff > 1 || diff < -1) return false;
            else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || visited[i - j]) return false;
                    if (map[i][column] != map[i - j][column]) return false;
                    visited[i - j] = true;
                }
            }
            else if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || visited[i + j]) return false;
                    if (map[i][column] - 1 != map[i + j][column]) return false;
                    visited[i + j] = true;
                }
            }
        }
        return true;

    }
}
