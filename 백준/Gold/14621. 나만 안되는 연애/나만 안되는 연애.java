import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char[] school;
    static int[] parents;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        school = new char[N + 1];
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) school[i] = st.nextToken().charAt(0);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            list.add(new Node(from, to, wight));
        }

        System.out.print(solve());
    }

    public static long solve() {
        Collections.sort(list);
        long result = 0;
        int cnt = 0;

        for (Node node : list) {
            if (find(node.from) != find(node.to)
                    && school[node.from] != (school[node.to])) {
                union(node.from, node.to);
                result += node.wight;
                cnt++;
            }
        }

        return cnt != N - 1 ? -1 : result;
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
        long wight;

        public Node(int to, int from, long wight) {
            this.from = to;
            this.to = from;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (wight - o.wight);
        }
    }
}
