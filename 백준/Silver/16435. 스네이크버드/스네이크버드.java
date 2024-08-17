import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        boolean[] visited = new boolean[N];

        while (true) {
            boolean update = false;

            for (int i = 0; i < N; i++) {
                if (!visited[i] && arr[i] <= M) {
                    visited[i] = true;
                    M++;
                    update = true;
                }
            }

            if (!update) break;
        }

        return M;
    }
}
