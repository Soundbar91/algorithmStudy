import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N, max = -1, min = -1;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        solve();
        br.close();
    }

    public static void solve() {
        int maxLen = 1, minLen = 1;

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] <= arr[i + 1]) maxLen++;
            else {
                max = Math.max(max, maxLen);
                maxLen = 1;
            }

            if (arr[i] >= arr[i + 1]) minLen++;
            else {
                min = Math.max(min, minLen);
                minLen = 1;
            }
        }

        max = Math.max(max, maxLen);
        min = Math.max(min, minLen);

        System.out.print(Math.max(max, min));
    }
}
