import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, K;
    static long result;
    static Queue<int[]> queue = new LinkedList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            queue.add(new int[]{cur, 0});
            set.add(cur);
        }

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        while (K != 0) {
            int[] cur = queue.poll();

            if (!set.contains(cur[0] - 1)) build(cur[0] - 1, cur[1] + 1);
            if (!set.contains(cur[0] + 1) && K > 0) build(cur[0] + 1, cur[1] + 1);
        }

        return result;
    }

    public static void build(int cur, int weight) {
        K--;
        result += weight;
        queue.add(new int[]{cur, weight});
        set.add(cur);
    }
}
