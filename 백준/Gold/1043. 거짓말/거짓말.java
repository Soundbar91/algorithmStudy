import java.io.*;
import java.util.*;

/**
 * 과장을 해서 말하고, 몇몇 사람들은 그 이야기의 진실을 안다.
 * 해당 사람들이 오면 진실을 말한다.
 * 어떤 파티에서 진실, 어떤 파티에서 과장 -> 거짓말쟁이
 * 모든 파티에 참가, 거짓말쟁이로 알려지지 않으면서 과장된 이야기를 할 수 있는 파티 개수
 *
 * 진실 확인 여부를 전파해야하는데
 * 차감을 해야겠네
 * 각 사람이 참여하는 파티
 * 누구에 의해 알게 됐다 ?
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
        int knowTruePeopleCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowTruePeopleCount; i++) {
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
