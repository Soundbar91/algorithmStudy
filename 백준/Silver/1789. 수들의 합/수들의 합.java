import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        System.out.print(solve(N));

        br.close();
    }

    public static long solve(long N) {
        long left = 1, right = N, ans = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long sum = (mid * (mid + 1)) / 2;

            if (sum == N) {
                ans = mid;
                break;
            }
            else if (sum > N) right = mid - 1;
            else {
                ans = Math.max(ans, mid);
                left = mid + 1;
            }
        }

        return ans;
    }
}
