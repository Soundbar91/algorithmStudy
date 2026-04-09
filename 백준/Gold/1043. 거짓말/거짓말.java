import java.io.*;
import java.util.*;

/**
 * 1043. 거짓말
 * 파티에 진실을 아는 사람이 있다면 진실을 말하고, 그렇지 않는 경우에는 과장해서 말한다.
 * 과장된 이야기를 할 수 있는 파티 개수의 최댓값을 구한다.
 *
 * - 파티 모두를 순회하면서 진실을 아는 사람을 업데이트 한다.
 * - 파티 모두를 순회하면서 과장을 말할 수 있는 파티의 개수를 구한다.
 */

public class Main {

    static int N, M;
    static boolean[] visited;
    static boolean[] result;
    static Queue<Integer> queue = new LinkedList<>();
    static List<List<Integer>> parties = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M + 1];
        result = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i <= M; i++) {
            parties.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int knowPeopleCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowPeopleCount; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int joinPeopleCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < joinPeopleCount; j++) {
                int peopleNum = Integer.parseInt(st.nextToken());
                parties.get(i).add(peopleNum);
                graph.get(peopleNum).add(i);
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        bfs();
        countResult();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.addAll(parties.get(next));
                }
            }
        }
    }

    public static void countResult() {
        int count = 0;
        for (int i = 1; i <= M; i++) {
            if (!visited[i]) {
                count++;
            }
        }
        System.out.print(count);
    }
}
