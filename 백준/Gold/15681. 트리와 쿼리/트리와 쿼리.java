import java.io.*;
import java.util.*;

public class Main {

    static int N, R, Q;
    static int[] size;
    static int[] parents;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        size = new int[N + 1];
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph.get(U).add(V);
            graph.get(V).add(U);
        }

        parents[R] = -1;
        makeTree(R);

        for (int i = 0; i < Q; i++) {
            System.out.println(size[Integer.parseInt(br.readLine())]);
        }

        br.close();
    }

    public static void makeTree(int cur) {
        size[cur] = 1;
        for (int next : graph.get(cur)) {
            if (parents[next] == cur) {
                continue;
            }

            if (parents[next] == 0) {
                parents[next] = cur;
                makeTree(next);
                size[cur] += size[next];
            }
        }
    }
}
