import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] visited;
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

            System.out.println(solve(cur, dest));
        }

        br.close();
    }

    public static int solve(int cur, int dest) {
        Queue<Line> queue = new LinkedList<>();
        visited = new boolean[N + 1];
        queue.add(new Line(cur, 0));
        visited[cur] = true;

        while (!queue.isEmpty()) {
            Line line = queue.poll();

            if (line.dest == dest) {
                return line.weight;
            }
            
            for (Line next : graph.get(line.dest)) {
                if (!visited[next.dest]) {
                    visited[next.dest] = true;
                    queue.add(new Line(next.dest, next.weight + line.weight));
                }
            }
        }
        
        return -1;
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
