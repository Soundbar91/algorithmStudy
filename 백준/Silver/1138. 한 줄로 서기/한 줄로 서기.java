import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N;
    static boolean[] visited;
    static int[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();

        result = new int[N];
        visited = new boolean[N];

        solve(0);
    }

    public static void solve(int depth) {
        if (depth == N) {
            if (check()) {
                for (int i = 0; i < N; i++) {
                    System.out.print(result[i] + 1 + " ");
                }
                System.exit(0);
            }
        }
        else {
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    result[depth] = i;
                    visited[i] = true;
                    solve(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static boolean check() {
        for (int i = 0; i < N; i++) {
            int count = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (result[j] > result[i]) count++;
            }

            if (count != arr[result[i]]) return false;
        }

        return true;
    }
}
