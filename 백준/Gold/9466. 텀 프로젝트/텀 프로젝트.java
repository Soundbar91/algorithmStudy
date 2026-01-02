import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] graph;
    static boolean[] visited;
    static boolean[] isTeam;
    static int count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            graph = new int[N + 1];
            visited = new boolean[N + 1];
            isTeam = new boolean[N + 1];
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            solve();
        }

        System.out.print(sb);
        br.close();
    }

    public static void solve() {
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        sb.append(N - count).append("\n");
    }

    public static void dfs(int node) {
        visited[node] = true;
        int next = graph[node];

        if (!visited[next]) {
            dfs(next);
        } else if (!isTeam[next]) {
            int current = next;
            do {
                count++;
                current = graph[current];
            } while (current != next);
        }

        isTeam[node] = true;
    }
}