import java.io.*;
import java.util.*;

public class Main {

    static int T, N, K, W;
    static int[] times;
    static int[] dist;
    static int[] dp;
    static List<List<Integer>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            dp = new int[N + 1];
            times = new int[N + 1];
            graph = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph.get(A).add(B);
                dist[B]++;
            }

            W = Integer.parseInt(br.readLine());
            solve();
        }

        System.out.print(sb);
        br.close();
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) {
                queue.add(i);
                dp[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == W) {
                sb.append(dp[cur]).append("\n");
                break;
            }


            for (int next : graph.get(cur)) {
                dist[next]--;
                dp[next] = Math.max(dp[next], dp[cur] + times[next]);

                if (dist[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}