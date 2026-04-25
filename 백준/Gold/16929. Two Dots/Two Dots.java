import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int distX;
    static int distY;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                visited = new boolean[N][M];
                visited[i][j] = true;
                distX = j;
                distY = i;
                dfs(j, i, 1);
            }
        }

        System.out.print("No");
    }

    public static void dfs(int x, int y, int cnt){
        for (int i = 0; i < 4; i++) {
            int ux = x + dx[i];
            int uy = y + dy[i];

            if (valid(ux, uy) && map[uy][ux] == map[y][x]) {
                if (!visited[uy][ux]) {
                    visited[uy][ux] = true;
                    dfs(ux, uy, cnt + 1);
                }
                else {
                    if ((ux == distX && uy == distY) && cnt >= 4) {
                        System.out.print("Yes");
                        System.exit(0);
                    }
                }
            }
        }
    }

    public static boolean valid(int x, int y){
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
}
