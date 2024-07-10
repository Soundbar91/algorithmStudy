import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long n = Long.parseLong(br.readLine());
            System.out.println(solve(n));
        }

        br.close();
    }

    public static long solve(long n) {
        if (n < 2) return 2;

        while (true) {
            boolean update = false;

            for (long i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    n++;
                    update = true;
                    break;
                }
            }

            if (!update) return n;
        }
    }
}
