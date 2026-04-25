import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parents;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list.add(new Node(0, i, Integer.parseInt(br.readLine())));
            parents[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (i != j) list.add(new Node(i, j, value));
            }
        }

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        Collections.sort(list);
        long result = 0;
        int count = 0;

        for (Node node : list) {
            if (find(node.from) != find(node.to)) {
                union(node.from, node.to);
                result += node.wight;
                if (++count == N) break;
            }
        }

        return result;
    }

    public static int find(int x) {
        if (parents[x] == x) return x;
        else return find(parents[x]);
    }

    public static void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx != ry) parents[ry] = rx;
    }

    public static class Node implements Comparable<Node> {
        int from;
        int to;
        int wight;

        public Node(int to, int from, int wight) {
            this.from = to;
            this.to = from;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return wight - o.wight;
        }
    }
}
