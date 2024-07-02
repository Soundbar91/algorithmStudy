import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[] chars;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            chars = br.readLine().toCharArray();
            Arrays.sort(chars);
            visited = new boolean[chars.length];
            solve(0, new char[chars.length]);
        }

        System.out.println(sb);
        br.close();
    }

    public static void solve(int depth, char[] result) {
        if (depth == chars.length) {
            for (char c : result) sb.append(c);
            sb.append('\n');
        }
        else {
            char prev = ' ';

            for (int i = 0; i < chars.length; i++) {
                if (visited[i]) continue;

                if (prev != chars[i]) {
                    prev = chars[i];
                    visited[i] = true;
                    result[depth] = chars[i];
                    solve(depth + 1, result);
                    visited[i] = false;
                }
            }
        }
    }
}
