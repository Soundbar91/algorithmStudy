import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        solve(N);
        br.close();
    }

    public static void solve(int N) {
        if (N == 1) return;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                System.out.println(i);
                N = N / i;
                i--;
            }
        }

        System.out.print(N);
    }
}
