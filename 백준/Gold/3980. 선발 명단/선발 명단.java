import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result;
    static boolean[] visited;
    static int[][] ability;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            result = 0;
            visited = new boolean[11];
            ability = new int[11][11];

            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    ability[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            solve(0, 0);
            System.out.println(result);
        }

        br.close();
    }

    public static void solve(int depth, int sum) {
        if (depth == 11) {
            result = Math.max(result, sum);
        }
        else {
            for (int i = 0; i < 11; i++) {
                if (visited[i] || ability[i][depth] == 0) continue;

                visited[i] = true;
                sum += ability[i][depth];
                solve(depth + 1, sum);
                visited[i] = false;
                sum -= ability[i][depth];
            }
        }
    }
}
