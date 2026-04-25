import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static Integer[] drank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        drank = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        System.out.print(solve());
    }

    public static double solve() {
        Arrays.sort(drank, Collections.reverseOrder());
        double result = (double) drank[0];

        for (int i = 1; i < drank.length; i++) {
            result += ((double) drank[i]) / 2;
        }

        return result;
    }
}
