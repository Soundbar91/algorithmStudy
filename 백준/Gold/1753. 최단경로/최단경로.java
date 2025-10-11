import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int V, E, K;
    static int[] dist;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        solve();
        br.close();
    }

    public static void solve() {
        dijkstra();
        print();
    }

    public static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        dist[K] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (dist[cur.v] != cur.w) continue;

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] <= dist[cur.v] + next.w) continue;
                dist[next.v] = dist[cur.v] + next.w;
                queue.add(new Node(next.v, dist[next.v]));
            }
        }
    }

    public static void print() {
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(dist[i]);
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
}
