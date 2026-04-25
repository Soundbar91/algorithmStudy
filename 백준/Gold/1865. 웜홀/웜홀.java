import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N;
    static int M;
    static int W;
    static int[] dist;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if (i < M) {
                    graph.get(S).add(new Edge(E, T));
                    graph.get(E).add(new Edge(S, T));
                }
                else {
                    graph.get(S).add(new Edge(E, -T));
                }
            }

            boolean result = false;
            for (int i = 1; i <= N; i++) {
                if (solve(i)) {
                    result = true;
                    break;
                }
            }

            sb.append(result ? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        br.close();
    }

    public static boolean solve(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean update = false;
        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (Edge e : graph.get(j)) {
                    if (dist[j] != INF && dist[e.to] > dist[j] + e.cost) {
                        dist[e.to] = dist[j] + e.cost;
                        update = true;
                    }
                }
            }

            if (!update) break;
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (Edge e : graph.get(i)) {
                    if (dist[i] != INF && dist[e.to] > dist[i] + e.cost) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static class Edge {
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
