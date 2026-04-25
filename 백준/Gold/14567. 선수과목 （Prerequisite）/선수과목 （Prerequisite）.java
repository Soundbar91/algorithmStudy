import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] result;
    static int[] edgeCount;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edgeCount = new int[N + 1];
        result = new int[N + 1];
        for (int i = 0; i <= N; i++) map.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map.get(x).add(y);
            map.get(y).add(x);
            edgeCount[y]++;
        }

        solve();
    }

    public static void solve() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (edgeCount[i] == 0) queue.add(new int[]{i, 1});
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            result[node[0]] = node[1];
            
            for (int i : map.get(node[0])) {
                edgeCount[i]--;
                if (edgeCount[i] == 0) {
                    queue.add(new int[]{i, node[1] + 1});
                }
            }
        }

        for (int i = 1; i <= N; i++) System.out.print(result[i] + " ");
    }
}
