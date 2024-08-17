import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        M = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        Arrays.sort(arr);

        if (sum <= M) return arr[arr.length - 1];
        else {
            int left = 0, right = arr[arr.length - 1];
            int result = 0;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (sum(mid) > M) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                    result = Math.max(result, mid);
                }
            }

            return result;
        }
    }

    public static int sum(int high) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(arr[i], high);
        }
        return sum;
    }
}
