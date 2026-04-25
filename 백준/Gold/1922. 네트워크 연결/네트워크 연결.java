import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] parents;
    static ArrayList<Node> list = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
    }

    public static void init() {
        for (int i = 1; i <= N; i++) parents[i] = i;
    }

    public static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        init();

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, weight));
        }

        System.out.print(solve());
    }

    public static long solve() {
        Collections.sort(list);
        int result = 0;
        int cnt = 0;

        for (Node node : list) {
            if (union(node.to, node.from)) {
                result += node.weight;
                if (cnt++ == M - 1) break;
            }
        }

        return result;
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        else return find(parents[x]);
    }

    public static boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) return false;
        else parents[ry] = rx;
        return true;
    }

    public static class Node implements Comparable<Node>{
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
