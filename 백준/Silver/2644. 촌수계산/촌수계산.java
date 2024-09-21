import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int n, m, a, b;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int i : list.get(a)) {
            visited = new boolean[n + 1];
            visited[i] = true;
            int solve = solve(i, b, 1);
            if (solve != -1) {
                System.out.print(solve);
                System.exit(0);
            }
        }

        for (int i : list.get(b)) {
            visited = new boolean[n + 1];
            visited[i] = true;
            int solve = solve(i, a, 1);
            if (solve != -1) {
                System.out.print(solve);
                System.exit(0);
            }
        }

        System.out.print(-1);
        br.close();
    }

    public static int solve(int x, int y, int depth) {
        if (x == y) return depth;
        else {
            for (int i : list.get(x)) {
                if (!visited[i]) {
                    visited[i] = true;
                    int result = solve(i, y, depth + 1);
                    if (result != -1) return result;
                    visited[i] = false;
                }
            }
            return -1;
        }
    }
}
