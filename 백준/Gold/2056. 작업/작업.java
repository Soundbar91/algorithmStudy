import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    static int[] dist;
    static int[] times;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        dist = new int[N + 1];
        times = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            times[i] = time;

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(i).add(next);
                dist[next]++;
            }
        }

        solve();
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

            for (int next : graph.get(cur)) {
                dist[next]--;
                dp[next] = Math.max(dp[next], dp[cur] + times[next]);

                if (dist[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[i]);
        }
        System.out.print(result);
    }
}