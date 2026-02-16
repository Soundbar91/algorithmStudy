import java.io.*;
import java.util.*;

/**
 * 기본 부품과 그 기본 부품을 조립하여 만든 중간 부품이 사용된다.
 * 기본 부품은 다른 부품을 사용하여 조립될 수 없는 부품
 * 중간 부품은 또 다른 중간 부품이나 기본 부품을 이용하여 만들어지는 부품
 * 진입 가선이 0 -> 기본 부품
 *
 */

public class Main {

    static int N;
    static int M;
    static int[] dist;
    static int[][] dp;
    static List<List<Line>> graph = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            graph.get(Y).add(new Line(X, K));
            dist[X]++;
        }

        solve();
        br.close();
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N; i++) {
            if (dist[i] == 0) {
                queue.add(i);
                dp[i][i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (Line next : graph.get(cur)) {
                dist[next.dest]--;
                for (int i = 1; i < N; i++) {
                    dp[next.dest][i] += next.count * dp[cur][i];
                }

                if (dist[next.dest] == 0) {
                    queue.add(next.dest);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dp[N][i] > 0) {
                System.out.println(i + " " + dp[N][i]);
            }
        }
    }

    public static class Line {
        int dest;
        int count;

        public Line(int dest, int count) {
            this.dest = dest;
            this.count = count;
        }
    }
}
