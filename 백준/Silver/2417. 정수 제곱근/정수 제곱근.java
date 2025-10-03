import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());
        System.out.println(solve());
        br.close();
    }

    public static long solve() {
        long left = 0;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (Math.pow(mid, 2) >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right + 1;
    }
}
