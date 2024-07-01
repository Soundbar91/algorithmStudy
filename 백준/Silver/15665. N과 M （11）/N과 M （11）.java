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
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
            for (int value : list) sb.append(value).append(' ');
            sb.append('\n');
        }
        else {
            int preValue = 0;
            for (int i = 0; i < N; i++) {
                int nextValue = nums[i];
                if (preValue != nextValue) {
                    list.add(nextValue);
                    preValue = nextValue;
                    solve();
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
