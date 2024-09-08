import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static final int END = 123456 * 2 + 1;
    static boolean[] prime = new boolean[END];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;
            else
                System.out.println(solve(n));
        }

        br.close();
    }

    public static int solve(int n) {
        int count = 0;

        for (int i = n + 1; i <= 2 * n; i++) {
            if (!prime[i]) count++;
        }

        return count;
    }

    public static void init() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i * i <= END; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= END; j += i) {
                    prime[j] = true;
                }
            }
        }
    }
}
