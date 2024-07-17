import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) map.add(new ArrayList<>());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;
            solve(i, 0);
        }

        System.out.print(0);
        br.close();
    }

    public static void solve(int cur, int depth) {
        if (depth == 4) {
            System.out.print(1);
            System.exit(0);
        }
        else {
            for (int next : map.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    solve(next, depth + 1);
                    visited[next] = false;
                }
            }
        }
    }
}
