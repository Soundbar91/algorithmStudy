import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int T, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            System.out.println(solve());
        }

        br.close();
    }

    public static long solve() {
        long result = 0L;
        int maxIndex = N - 1;

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] < arr[maxIndex]) result += (arr[maxIndex] - arr[i]);
            else maxIndex = i;
        }

        return result;
    }
}
