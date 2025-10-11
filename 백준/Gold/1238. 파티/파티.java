import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int X;
    static boolean[] visited;
    static int[] dist;
    static int[] reverse_dist;
    static ArrayList<ArrayList<Node>> map = new ArrayList<>();
    static ArrayList<ArrayList<Node>> reverse_map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
            reverse_map.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map.get(a).add(new Node(b, c));
            reverse_map.get(b).add(new Node(a, c));
        }

        int result = -1;

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        reverse_dist = new int[N + 1];
        Arrays.fill(reverse_dist, Integer.MAX_VALUE);

        visited = new boolean[N + 1];
        solve(map, X, dist);
        visited = new boolean[N + 1];
        solve(reverse_map, X, reverse_dist);

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dist[i] + reverse_dist[i]);
        }

        System.out.print(result);
    }

    public static void solve(ArrayList<ArrayList<Node>> map, int startPoint, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startPoint, 0));
        dist[startPoint] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            visited[cur.index] = true;

            for (Node next : map.get(cur.index)) {
                if (visited[next.index]) continue;
                if (dist[next.index] > dist[cur.index] + next.weight) {
                    dist[next.index] = dist[cur.index] + next.weight;
                    pq.add(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
