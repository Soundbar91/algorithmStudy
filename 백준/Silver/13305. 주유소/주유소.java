import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static long[] dist;
    static long[] gas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dist = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        gas = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solve());
    }

    public static long solve() {
        long minGas = gas[0];
        long result = dist[0] * gas[0];

        for (int i = 1; i < N - 1; i++) {
            minGas = Math.min(minGas, gas[i]);
            result += dist[i] * minGas;
        }

        return result;
    }
}
