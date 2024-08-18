import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        long count = 0, sum = 1, left = 1, right = 1;

        while (right != N) {

            if (sum == N) {
                count++;
                right++;
                sum += right;
            }
            else if (sum > N) {
                sum -= left;
                left++;
            }
            else {
                right++;
                sum += right;
            }

        }

        return count + 1;
    }
}
