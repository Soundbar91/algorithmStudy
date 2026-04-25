import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int K;
    static int[] coordinate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        coordinate = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        Arrays.sort(coordinate);
        int[] temp = new int[N - 1];
        long result = 0;

        for (int i = 0; i < N - 1; i++) temp[i] = coordinate[i + 1] - coordinate[i];

        Arrays.sort(temp);
        for (int i = 0; i < N - (K - 1) - 1; i++)
            result += temp[i];

        return result;
    }
}
