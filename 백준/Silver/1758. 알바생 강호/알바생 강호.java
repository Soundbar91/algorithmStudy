import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static long[] tip;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tip = br.lines().limit(N).mapToLong(Long::parseLong).toArray();

        System.out.print(solve());
    }

    public static long solve() {
        Arrays.sort(tip);

        long result = 0;
        int index = 1;

        for (int i = tip.length - 1; i >= 0; i--) {
            long temp = tip[i] - (index++ - 1);
            if (temp >= 0) result += temp;
        }

        return result;
    }
}