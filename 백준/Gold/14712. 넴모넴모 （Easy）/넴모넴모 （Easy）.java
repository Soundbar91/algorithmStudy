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

        solve(0, 0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int depth, int start) {
        if (check(depth)) result++;
        if (depth == N * M) return;

        for (int i = start; i < N * M; i++) {
            int x = i / M, y = i % M;
            if (visited[x][y]) continue;

            visited[x][y] = true;
            solve(depth + 1, i + 1);
            visited[x][y] = false;
        }
    }

    public static boolean check(int depth) {
        if (depth < 3) return true;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if(visited[i][j] && visited[i][j + 1]
                        && visited[i + 1][j] && visited[i + 1][j + 1])
                    return false;
            }
        }

        return true;
    }
}
