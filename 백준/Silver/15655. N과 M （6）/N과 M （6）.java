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
        vistied = new boolean[N];
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        solve(0);
        br.close();
    }

    public static void solve(int index) {
        if (list.size() == M) {
            for (int value : list) System.out.print(value + " ");
            System.out.println();
        }
        else {
            for (int i = index; i < N; i++) {
                if (nums[index] > nums[i]) continue;
                if (!vistied[i]) {
                    vistied[i] = true;
                    list.add(nums[i]);
                    solve(i + 1);

                    vistied[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
