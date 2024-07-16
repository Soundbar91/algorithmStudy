import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, K;
    static int[] move = {-1, 1, 2};
    static boolean[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[100001];

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == K) return cur[1];

            if (map[cur[0]]) continue;
            map[cur[0]] = true;

            for (int i = 0; i < 3; i++) {
                int next = i < 2 ? cur[0] + move[i] : cur[0] * move[i];
                int time = i < 2 ? cur[1] + 1 : cur[1];

                if (next < 0 || next > 100000 || map[next]) continue;
                queue.add(new int[]{next, time});
            }
        }

        return -1;
    }
}
