import java.io.*;
import java.util.*;

/**
 * 1238. 파티
 * N개의 마을에 한 명의 학생이 살고 있음
 * X번 마을에서 파티, M개의 단방향 도로
 * 최단 시간에 왕복해야함. N명의 학생들 중 오고 가는데 가장 많은 시간을 소비한 학생
 *
 * X에서 모든 정점까지의 거리를 구한다 -> 다익스트라 -> 돌아갈 때 거리를 구할 수 있음
 * 그럼 N개의 마을에서 X로 가는 거리의 가중치를 구할려면, 각 마을에서 BFS를 돌린다 ?
 * -> BFS는 가중치가 없을 때 최단 경로를 구하는 알고리즘
 *
 * X에서 모든 정점까지의 거리를 구한다
 * - 입력으로 주어진 그래프에서 다익스트라를 돌리면 파티가 끝나고 돌아갈 때의 최단 거리를 구할 수 있음
 * - 모든 정점에서 X로 다익스트라를 돌리면 총 N - 1번의 다익스트라를 돌려야함.
 * - 이때 간선을 모두 역전하고, X에서 다익스트라를 돌리면 모든 정점에서 X까지의 최단거리를 구할 수 있는 효과를 볼 수 있음
 */

public class Main {

    static int N, M, X;
    static List<List<Node>> forwardGraph = new ArrayList<>();
    static List<List<Node>> reverseGraph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            forwardGraph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            forwardGraph.get(src).add(new Node(dest, weight));
            reverseGraph.get(dest).add(new Node(src, weight));
        }

        solve();
        br.close();
    }

    public static void solve() {
        int[] forwardDist = dijkstra(forwardGraph);
        int[] reverseDist = dijkstra(reverseGraph);

        int result = -1;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                result = Math.max(result, forwardDist[i] + reverseDist[i]);
            }
        }

        System.out.print(result);
    }

    public static int[] dijkstra(List<List<Node>> graph) {
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(X, 0));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 987654321);
        dist[X] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (dist[cur.dest] < cur.weight) {
                continue;
            }

            for (Node next : graph.get(cur.dest)) {
                if (dist[next.dest] > dist[cur.dest] + next.weight) {
                    dist[next.dest] = dist[cur.dest] + next.weight;
                    queue.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        return dist;
    }

    public static class Node implements Comparable<Node> {
        int dest;
        int weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
