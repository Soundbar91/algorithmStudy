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
    static int n, m, start, end;
    static int[] dist;
    static int[] prev;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1];
        prev = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        solve();
        br.close();
    }

    public static void solve() {
        dijkstra(start);
        print();
    }

    public static void dijkstra(int start) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;
        prev[start] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (dist[cur.v] != cur.w) continue;

            for (Node next : graph.get(cur.v)) {
                if (dist[next.v] <= dist[cur.v] + next.w) continue;
                dist[next.v] = dist[cur.v] + next.w;
                queue.add(new Node(next.v, dist[next.v]));
                prev[next.v] = cur.v;
            }
        }
    }

    public static void print() {
        System.out.println(dist[end]);
        int prevIndex = end;
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (prev[prevIndex] == 0) {
                list.add(prevIndex);
                break;
            }
            else {
                list.add(prevIndex);
                prevIndex = prev[prevIndex];
            }
        }
        System.out.println(list.size());

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
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
