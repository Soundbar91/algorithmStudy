import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int N;
    static Integer[] pay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pay = br.lines()
                .limit(N)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println(solve());
    }

    public static int solve() {
        if (pay.length <= 2) return Arrays.stream(pay).mapToInt(Integer::intValue).sum();

        Arrays.sort(pay, Comparator.reverseOrder());
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (i % 3 != 2) result += pay[i];
        }

        return result;
    }
}
