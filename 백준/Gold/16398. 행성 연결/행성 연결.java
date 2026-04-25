import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new List[N + 1];
        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i].add(new Node(j, Integer.parseInt(st.nextToken())));
            }
        }

        System.out.print(solve());
    }

    public static long solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(1, 0));
        long result = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.to]) continue;
            visited[node.to] = true;
            result += node.wight;

            for (Node next : map[node.to]) {
                if (!visited[next.to]) pq.add(new Node(next.to, next.wight));
            }
        }

        return result;
    }

    public static class Node implements Comparable<Node> {
        int to;
        int wight;

        public Node(int to, int weight) {
            this.to = to;
            this.wight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return wight - o.wight;
        }
    }
}
