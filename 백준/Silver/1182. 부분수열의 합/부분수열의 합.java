import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, S, result;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        solve(0, 0);
        if (S == 0) result--;
        System.out.print(result);
        br.close();
    }

    public static void solve(int sum, int depth) {
        if (depth == N) {
            if (sum == S) result++;
            else return ;
        }
        else {
            solve(sum + nums[depth], depth + 1);
            solve(sum, depth + 1);
        }
    }
}
