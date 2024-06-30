import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        solve();
        System.out.print(sb);
        br.close();
    }

    public static void solve() {
        if (list.size() == M) {
            for (int value : list) sb.append(value).append(" ");
            sb.append('\n');
        }
        else {
            int preValue = 0;
            for (int i = 0; i < N; i++) {
                int nextValue = nums[i];
                if (!visited[i] && preValue != nextValue) {
                    visited[i] = true;
                    list.add(nextValue);
                    preValue = nextValue;
                    solve();
                    visited[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
