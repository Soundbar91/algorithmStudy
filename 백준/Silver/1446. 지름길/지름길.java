import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, D;
    static int[] dp;
    static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, weight));
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        dp = new int[D + 1];
        for (int i = 0; i <= D; i++) dp[i] = i;

        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            for (Edge edge : edges) {
                if (edge.to == i) {
                    dp[i] = Math.min(dp[i], dp[edge.from] + edge.weight);
                }
            }
        }

        return dp[D];
    }

    public static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
