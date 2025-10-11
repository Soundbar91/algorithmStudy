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
    static int t, n, d, c;
    static int[] dist;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                graph.get(v).add(new Node(u, w));
            }

            solve();
        }

        br.close();
    }

    public static void solve() {
        dijkstra();
        print();
    }

    public static void dijkstra() {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(c, 0));
        dist[c] = 0;

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
        int count = 0;
        int time = -1;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                count++;
                time = Math.max(time, dist[i]);
            }
        }

        System.out.print(count + " " + time + "\n");
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
            return Integer.compare(this.v, o.v);
        }
    }
}
