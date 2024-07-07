import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    static int M, N, sum;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        solve();
        try {
            System.out.print(sum + "\n" + list.get(0));
        } catch (Exception e) {
            System.out.print(-1);
        }
        br.close();
    }

    public static void solve() {
        for (int i = M; i <= N; i++) {
            if (check(i)) {
                list.add(i);
                sum += i;
            }
        }
    }

    public static boolean check(int n) {
        if (n < 2) return false;
        if (n == 2) return true;

        return IntStream.range(2, n).noneMatch(i -> n % i == 0);
    }
}
