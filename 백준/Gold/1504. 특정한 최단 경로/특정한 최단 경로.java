import java.io.*;
import java.util.*;

public class Main {

    static int N, E, v1, v2;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        solve();
        br.close();
    }

    public static void solve() {
        int[] d1 = dijkstra(1);
        int[] d2 = dijkstra(v1);
        int[] d3 = dijkstra(v2);

        int path1 = -1;
        if (d1[v1] != 987654321 && d2[v2] != 987654321 && d3[N] != 987654321) {
            path1 = d1[v1] + d2[v2] + d3[N];
        }

        int path2 = -1;
        if (d1[v2] != 987654321 && d3[v1] != 987654321 && d2[N] != 987654321) {
            path2 = d1[v2] + d3[v1] + d2[N];
        }

        if (path1 == -1 && path2 == -1) {
            System.out.println(-1);
        } else if (path1 == -1) {
            System.out.println(path2);
        } else if (path2 == -1) {
            System.out.println(path1);
        } else {
            System.out.println(Math.min(path1, path2));
        }
    }

    public static int[] dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 987654321);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (dist[cur.v] < cur.w) {
                continue;
            }

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
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
            return this.w - o.w;
        }
    }
}
