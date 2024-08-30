import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int result = 1;
        int prev = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - prev >= L) {
                result++;
                prev = arr[i];
            }
        }

        return result;
    }
}
