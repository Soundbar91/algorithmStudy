import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] visited;
    static List<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        solve(1);
        br.close();
    }

    public static void solve(int startPoint) {
        if (list.size() == M) {
            for (int value : list) System.out.print(value + " ");
            System.out.println();
        }
        else {
            for (int i = startPoint; i <= N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(i);
                    solve(i + 1);

                    visited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
