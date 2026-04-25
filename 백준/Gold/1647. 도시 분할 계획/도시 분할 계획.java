import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    static int N;
    static int M;
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
            int wight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to, wight));
            map[to].add(new Node(from, wight));
        }

        System.out.print(solve());
    }

    public static long solve() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        List<Integer> temp = new ArrayList<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.to]) continue;
            visited[node.to] = true;
            temp.add(node.wight);

            for (Node next : map[node.to]) {
                if (!visited[next.to]) pq.add(new Node(next.to, next.wight));
            }
        }

        Collections.sort(temp);

        long result = 0;
        for (int i = 0; i < temp.size() - 1; i++) result += temp.get(i);

        return result;
    }

    public static class Node implements Comparable<Node> {
        int to;
        int wight;

        public Node(int to, int wight) {
            this.to = to;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return wight - o.wight;
        }
    }
}
