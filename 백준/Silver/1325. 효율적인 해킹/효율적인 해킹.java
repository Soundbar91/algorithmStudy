import java.io.*;
import java.util.*;

/**
 * 1325. 효율적인 해킹
 * 한 번의 해킹으로 여러 개의 컴퓨터를 해킹할 수 있는 컴퓨터를 해킹
 * A가 B를 신뢰하는 경우 -> B를 해킹하면 A도 해킹할 수 있음
 * 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호 출력
 *
 * 모든 정점에 대해서 탐색을 돌려서 탐색 노드 개수를 구함
 * 이후 탐색 노드의 맥스 값을 구함
 * 맥스값에 해당하는 번호 카운팅
 * -> 시간 초과
 *
 * 탐색 노드의 맥스 값을 따로 구하는 것이 아니라 탐색이 끝날 때마다 갱신
 * -> 정답
 */

public class Main {

    static int N, M;
    static int[] counts;
    static int[] visited;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        counts = new int[N + 1];
        visited = new int[N + 1];
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
        }

        int maxCount = findMaxCount();
        System.out.print(findMaxComputer(maxCount));

        br.close();
    }

    public static int bfs(int src) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[src] = src;
        queue.add(src);
        int count = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (visited[next] == src) {
                    continue;
                }

                visited[next] = src;
                queue.add(next);
                count++;
            }
        }

        return count;
    }

    public static int findMaxCount() {
        int max = -1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, counts[i]);
        }

        return max;
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
