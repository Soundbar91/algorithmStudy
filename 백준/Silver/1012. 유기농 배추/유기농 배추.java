import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int M;   // 가로
    static int N;   // 세로
    static int K;   // 배추 개수
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visit = new int[N][M];

            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    if (visit[i][j] != 1 && map[i][j] == 1){
                        dfs(j, i);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        bw.write(String.valueOf(sb));
        bw.flush();
    }

    public static void dfs(int x, int y) {
        visit[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ux = x + dx[i];
            int uy = y + dy[i];

            if (ux < 0 || uy < 0 || ux >= M || uy >= N) continue;
            if (visit[uy][ux] != 1 && map[uy][ux] == 1) {
                dfs(ux, uy);
            }
        }
    }
}
