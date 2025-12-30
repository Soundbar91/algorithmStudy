import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, H, result = 4;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = true;
        }

        if (check()) {
            System.out.print(0);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            solve(1, 0, i);
            if (result != 4) {
                break;
            }
        }

        System.out.print(result == 4 ? -1 : result);
        br.close();
    }

    public static void solve(int start, int depth, int target) {
        if (result != 4) return;

        if (depth == target) {
            if (check()) {
                result = target;
            }
            return;
        }

        for (int i = start; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (!map[i][j] && !map[i][j - 1] && !map[i][j + 1]) {
                    map[i][j] = true;
                    solve(i, depth + 1, target);
                    map[i][j] = false;
                }
            }
        }
    }

    public static boolean check() {
        for (int i = 1; i <= N; i++) {
            int cur = i;

            for (int j = 1; j <= H; j++) {
                if (map[j][cur]) {
                    cur++;
                } else if (cur > 1 && map[j][cur - 1]) {
                    cur--;
                }
            }

            if (cur != i) {
                return false;
            }
        }
        return true;
    }
}