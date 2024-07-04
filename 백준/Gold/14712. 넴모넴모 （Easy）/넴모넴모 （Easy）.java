import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];

        solve(0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int depth) {
        if (depth == N * M) {
            result++;
            return;
        }

        int x = depth / M;
        int y = depth % M;

        solve(depth + 1);

        if (isValid(x, y)) {
            visited[x][y] = true;
            solve(depth + 1);
            visited[x][y] = false;
        }
    }

    public static boolean isValid(int x, int y) {
        if (x == 0 || y == 0) return true;
        return !(visited[x][y - 1] && visited[x - 1][y] && visited[x - 1][y - 1]);
    }
}