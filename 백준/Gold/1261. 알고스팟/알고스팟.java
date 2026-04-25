import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dist = new int[M][N];

        for (int i = 0; i < M; i++) Arrays.fill(dist[i], -1);
        dist[0][0] = 0;

        for (int i = 0; i < M; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = str[j] - '0';
            }
        }

        bfs(0, 0);
        System.out.print(dist[M - 1][N - 1]);
    }

    public static void bfs(int x, int y){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{x, y});

        while(!deque.isEmpty()) {
            int[] node = deque.pollFirst();
            int nodeX = node[0];
            int nodeY = node[1];

            for (int i = 0; i < 4; i++) {
                int ux = nodeX + dx[i];
                int uy = nodeY + dy[i];

                if (!valid(ux, uy)) continue;

                if (dist[uy][ux] == -1) {
                    if (map[uy][ux] == 1) {
                        dist[uy][ux] = dist[nodeY][nodeX] + 1;
                        deque.addLast(new int[]{ux, uy});
                    }
                    else {
                        dist[uy][ux] = dist[nodeY][nodeX];
                        deque.addFirst(new int[]{ux, uy});
                    }
                }
            }
        }
    }

    public static boolean valid(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
}
