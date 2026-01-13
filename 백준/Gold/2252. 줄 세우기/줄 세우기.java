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

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            dist[B]++;
        }

        solve();
        br.close();
    }

    public static void solve() {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                dist[next]--;

                if (dist[next] == 0) {
                    queue.add(next);
                }
            }
        }

        System.out.print(sb);
    }
}
