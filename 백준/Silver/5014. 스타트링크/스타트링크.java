import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        bfs();
        br.close();
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == G) {
                System.out.print(cur[1]);
                return ;
            }

            for (int nx : new int[] {cur[0] + U, cur[0] - D}) {
                if (!valid(nx) || visited[nx]) continue;
                visited[nx] = true;
                queue.add(new int[]{nx, cur[1] + 1});
            }
        }

        System.out.print("use the stairs");
    }

    public static boolean valid(int x) {
        return x >= 1 && x <= F;
    }
}
