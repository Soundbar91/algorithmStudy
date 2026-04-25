import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static long total;
    static List<Node>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new List[N + 1];
        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());

            map[from].add(new Node(to, weight));
            map[to].add(new Node(from, weight));
            total += weight;
        }

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        pq.add(new Node(1, 0));
        long result = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.to]) continue;
            visited[node.to] = true;
            result += node.wight;
            cnt++;

            for (Node next : map[node.to]) {
                if (!visited[next.to]) pq.add(new Node(next.to, next.wight));
            }
        }

        return cnt - 1 == N - 1 ? total - result : -1;
    }

    public static class Node implements Comparable<Node> {
        int to;
        long wight;

        public Node(int to, long wight) {
            this.to = to;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (wight - o.wight);
        }
    }
}
