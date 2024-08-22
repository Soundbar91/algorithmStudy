import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        long result = 0;

        Arrays.sort(arr);

        for (int i = 1; i <= N; i++) {
            result += Math.abs(arr[i] - i);
        }

        return result;
    }
}
