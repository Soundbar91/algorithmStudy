import java.io.*;
import java.util.*;

/**
 * 1325. 효율적인 해킹
 * 한 번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있는 컴퓨터를 해킹
 * A가 B를 신뢰하는 경우 -> B를 해킹하면 A도 해킹할 수 있음
 * 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호 출력
 *
 * 방향 그래프, 모든 정점에 대해서 탐색을 돌림
 * 탐색한 노드의 개수를 구함, 맥스값 구함
 * -> 시간 초과
 *
 *
 */

public class Main {

    static int N, M, max = -1;
    static int[] counts;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        counts = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            graph.get(dest).add(src);
        }

        for (int i = 1; i <= N; i++) {
            counts[i] = bfs(i);
            max = Math.max(max, counts[i]);
        }

        System.out.print(findMaxComputer(max));
        br.close();
    }

    public static int bfs(int src) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        visited[src] = true;
        queue.add(src);
        int count = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);
                count++;
            }
        }

        return count;
    }

    public static String findMaxComputer(int maxCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == maxCount) {
                sb.append(i).append(" ");
            }
        }

        return sb.toString();
    }
}
