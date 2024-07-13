import java.io.*;
import java.util.*;

class Main {
    static int N, M, max;
    static boolean[] visited;
    static int[] result;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        result = new int[N + 1];
        list = new List[N + 1];
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            solve(i);
        }


        for (int i = 1; i <= N; i++) max = Math.max(max, result[i]);
        for (int i = 1; i <= N; i++) if (result[i] == max) sb.append(i).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void solve(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : list[cur]) {
                if (!visited[next]) {
                    result[next]++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
