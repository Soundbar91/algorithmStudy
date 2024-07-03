import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        solve(0, 0);
        result.sort(null);

        try {
            System.out.print(result.get(N - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.print(-1);
        }
    }

    public static void solve(int depth, long sum) {
        if (depth == 10) {
            if (!result.contains(sum)) result.add(sum);
        }
        else {
            solve(depth + 1, sum);
            solve(depth + 1, sum * 10 + nums[depth]);
        }
    }
}
