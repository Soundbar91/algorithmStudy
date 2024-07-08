import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static int N, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (solve(Integer.parseInt(st.nextToken()))) result++;
        }

        System.out.print(result);
        br.close();
    }

    public static boolean solve(int n) {
        if (n < 2) return false;
        if (n == 2) return true;

        return IntStream.iterate(2, i -> i <= Math.sqrt(n), i -> i + 1).noneMatch(i -> n % i == 0);
    }
}
