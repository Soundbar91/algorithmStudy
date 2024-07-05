import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K, result;
    static boolean[] visited = init();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String substring = str.substring(4, str.length() - 4);
            list.add(substring);
        }

        if (K < 5) {
            System.out.print(0);
            System.exit(0);
        }

        solve(0, 0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int index, int depth) {
        if (depth == K - 5) read();
        else {
            for (int i = index; i < 26; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    solve(i + 1, depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void read() {
        int count = 0;
        for (String str : list) {
            char[] chars = str.toCharArray();
            boolean read = true;

            for (char c : chars) {
                if (!visited[c - 'a']) {
                    read = false;
                    break;
                }
            }
            if (read) count++;
        }
        result = Math.max(result, count);
    }

    public static boolean[] init() {
        boolean[] visited = new boolean[26];
        visited[0] = true;
        visited[2] = true;
        visited[8] = true;
        visited[13] = true;
        visited[19] = true;

        return visited;
    }
}
