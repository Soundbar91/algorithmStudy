import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        bfs();
        br.close();
    }

    public static void bfs() {
        Queue<JaeHwan> queue = new LinkedList<>();
        queue.add(new JaeHwan(0 ,0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            JaeHwan cur = queue.poll();

            if (cur.index == N - 1) {
                System.out.print(cur.jump);
                return ;
            }

            for (int i = 0; i <= nums[cur.index]; i++) {
                if (cur.index + i >= N || visited[cur.index + i]) continue;
                queue.add(new JaeHwan(cur.index + i, cur.jump + 1));
                visited[cur.index + i] = true;
            }
        }

        System.out.print(-1);
    }

    public static class JaeHwan {
        int index;
        int jump;

        public JaeHwan(int index, int jump) {
            this.index = index;
            this.jump = jump;
        }
    }
}
