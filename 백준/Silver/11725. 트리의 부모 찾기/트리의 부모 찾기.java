import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static List<List<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        dfs(1);
        for (int i = 2; i <= N; i++) System.out.println(parent[i]);
        br.close();
    }

    public static void dfs(int startPoint) {
        visited[startPoint] = true;

        for (int nextPoint : map.get(startPoint)) {
            if (!visited[nextPoint]) {
                parent[nextPoint] = startPoint;
                dfs(nextPoint);
            }
        }
    }
}
