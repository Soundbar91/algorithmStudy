import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int left = 0, right = 0, sum = 0, count = 0;

        while (true) {
            if (sum >= M) sum -= arr[left++];
            else if (right == N) break;
            else sum += arr[right++];

            if (sum == M) count++;
        }

        return count;
    }
}
