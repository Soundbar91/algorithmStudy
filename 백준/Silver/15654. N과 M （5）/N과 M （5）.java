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
    static boolean[] vistied;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);

        vistied = new boolean[N];

        solve();
        br.close();
    }

    public static void solve() {
        if (list.size() == M) {
            for (int value : list) System.out.print(value + " ");
            System.out.println();
        }
        else {
            for (int i = 0; i < N; i++) {
                if (!vistied[i]) {
                    vistied[i] = true;
                    list.add(nums[i]);
                    solve();

                    vistied[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
