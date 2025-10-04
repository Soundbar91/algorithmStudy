import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] time;
    static int[] dx = {-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = new int[100_001];
        Arrays.fill(time, -1);

        System.out.print(N == K ? 0 : solve());
        br.close();
    }

    public static int solve() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int j = 0; j < 3; j++) {
                int nx;
                if (j < 2) nx = cur + dx[j];
                else nx = cur * dx[j];

                if (nx == K) {
                    return time[cur] + 1;
                }
                if (!valid(nx)) continue;
                if (time[nx] != -1) continue;
                queue.add(nx);
                time[nx] = time[cur] + 1;
            }
        }

        return -1;
    }

    public static boolean valid(int x) {
        return x >= 0 && x < 100_001;
    }
}
