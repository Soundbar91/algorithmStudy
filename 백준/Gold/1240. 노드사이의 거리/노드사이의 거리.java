import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] size;
    static int[] parents;
    static List<List<Line>> graph = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(x).add(new Line(y ,w));
            graph.get(y).add(new Line(x, w));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            size = new int[N + 1];
            parents = new int[N + 1];
            solve(cur, dest, 0);
            System.out.println(size[dest]);
        }

        br.close();
    }

    public static void solve(int cur, int dest, int weight) {
        if (cur == dest) {
            return;
        }

        size[cur] += weight;
        for (Line next : graph.get(cur)) {
            if (parents[cur] == next.dest) {
                continue;
            }

            if (parents[next.dest] == 0) {
                parents[next.dest] = cur;
                solve(next.dest, dest, size[cur] + next.weight);
                size[next.dest] += (size[cur] + next.weight);
            }
        }
    }

    public static class Line {
        int dest;
        int weight;

        public Line(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
