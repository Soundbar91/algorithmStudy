import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l;
    static int knightX;
    static int knightY;
    static int destX;
    static int destY;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];

            StringTokenizer st = new StringTokenizer(br.readLine());
            knightY = Integer.parseInt(st.nextToken());
            knightX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destY = Integer.parseInt(st.nextToken());
            destX = Integer.parseInt(st.nextToken());

            bfs(knightX, knightY);
            sb.append(map[destY][destX]).append('\n');
        }

        System.out.print(sb);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeX = node[0];
            int nodeY = node[1];

            for (int i = 0; i < 8; i++){
                int ux = nodeX + dx[i];
                int uy = nodeY + dy[i];

                if (valid(ux, uy) && !visited[uy][ux]){
                    visited[uy][ux] = true;
                    queue.add(new int[]{ux, uy});
                    map[uy][ux] = map[nodeY][nodeX] + 1;
                }
            }
        }
    }

    public static boolean valid(int x, int y){
        return (x >= 0 && x < l) && (y >= 0 && y < l);
    }
}
