import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] dx = {1, 2, 3, 4, 5, 6};
    static int[] map = new int[101];
    static boolean[] visit = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0 ; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        solve();
        br.close();
    }

    public static void solve() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visit[1] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == 100) {
                System.out.print(node[1]);
                System.exit(0);
            }

            for (int i = 0; i < 6; i++) {
                int nextPoint = node[0] + dx[i];

                if (nextPoint > 100 || visit[nextPoint]) continue;
                if (map[nextPoint] != 0) nextPoint = map[nextPoint];

                queue.add(new int[]{nextPoint, node[1] + 1});
                visit[nextPoint] = true;
            }
        }
    }

}
