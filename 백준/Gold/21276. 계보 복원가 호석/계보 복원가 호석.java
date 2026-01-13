import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dist;
    static List<String> names = new ArrayList<>();
    static Map<String, Integer> nameMap = new HashMap<>();
    static Map<String, List<String>> childrenMap = new HashMap<>();
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dist = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            names.add(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            childrenMap.put(names.get(i), new ArrayList<>());
        }

        names.sort(null);
        for (int i = 0; i < N; i++) {
            nameMap.put(names.get(i), i);
        }


        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String child = st.nextToken();
            int childNumber = nameMap.get(child);
            String parent = st.nextToken();
            int parentNumber = nameMap.get(parent);

            graph.get(parentNumber).add(childNumber);
            dist[childNumber]++;
        }

        solve();
        br.close();
    }

    public static void solve() {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> root = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (dist[i] == 0) {
                root.add(i);
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph.get(cur)) {
                dist[next]--;

                if (dist[next] == 0) {
                    queue.add(next);
                    List<String> childrenNames = childrenMap.get(names.get(cur));
                    childrenNames.add(names.get(next));
                    childrenMap.put(names.get(cur), childrenNames);
                }
            }
        }

        sb.append(root.size()).append('\n');
        while (!root.isEmpty()) {
            sb.append(names.get(root.poll())).append(' ');
        }
        sb.append('\n');

        for (String name : names) {
            sb.append(name).append(' ');

            List<String> childrenNames = childrenMap.get(name);
            sb.append(childrenNames.size()).append(' ');
            childrenNames.sort(null);

            for (String childrenName : childrenNames) {
                sb.append(childrenName).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}