import java.io.*;
import java.util.*;

/**
 * 이분 그래프 -> 사이클이 있냐 없냐를 판단하면 될 거 같은데
 * 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있다.
 * 루트를 판별하기에는 무엇을 루트로 놔야할 지를 모르겠는데,
 * 두 개의 집합이 나오냐 안나오냐를
 */

public class Main {

    static int K, V, E;
    static int[] color;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            color = new int[V + 1];
            Arrays.fill(color, -1);
            graph = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            boolean flag = true;
            for (int i = 1; i <= V; i++) {
                if (color[i] == -1 && !bfs(i)) {
                    flag = false;
                    break;
                }
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int startColor = 1;
        queue.add(start);
        color[start] = startColor;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (color[next] == color[cur]) {
                    return false;
                }
                if (color[next] != -1 && color[next] != color[cur]) {
                    continue;
                }


                color[next] = 1 - color[cur];
                queue.add(next);
            }
        }

        return true;
    }
}
