import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dist;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());

            for (int j = 1; j < count; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(prev).add(next);
                dist[next]++;
                prev = next;
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result.add(cur);

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                dist[next]--;

                if (dist[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (result.size() != N) {
            System.out.print(0);
        } else {
            for (int i = 0; i < N; i++) {
                System.out.println(result.poll());
            }
        }
    }
}
