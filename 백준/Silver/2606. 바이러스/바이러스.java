import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;
    static boolean[] visited;
    static List<List<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        queue.add(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (visited[cur]) continue;
            visited[cur] = true;
            result++;

            for (int next : map.get(cur)) {
                if (!visited[next]) queue.add(next);
            }
        }

        return result == 0 ? 0 : result - 1;
    }
}
