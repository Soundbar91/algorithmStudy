import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        solve();
        br.close();
    }

    public static void solve() {
        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (K == 0) break;
            count += (K / coins[i]);
            K = K % coins[i];
        }

        System.out.print(count);
    }
}
