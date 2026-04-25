import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] parents;
    static Point[] points;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        points = new Point[N + 1];
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(i, x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            union(from, to);
        }

        System.out.printf("%.2f", solve());
        br.close();
    }

    public static double solve() {
        addLine();
        Collections.sort(list);

        double result = 0.0;

        for (Node node : list) {
            if (find(node.to) != find(node.from)) {
                result += node.wight;
                union(node.to, node.from);
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

    public static void addLine() {
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double weight = calc(points[i], points[j]);

                list.add(new Node(points[i].num, points[j].num, weight));
            }
        }
    }

    public static double calc(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    public static class Point {
        int num;
        double x;
        double y;

        public Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static class Node implements Comparable<Node> {
        int from;
        int to;
        double wight;

        public Node(int to, int from, double wight) {
            this.from = to;
            this.to = from;
            this.wight = wight;
        }

        @Override
        public int compareTo(Node o) {
            return wight < o.wight ? -1 : 1;
        }
    }
}
