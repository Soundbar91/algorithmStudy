import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        solve();
        br.close();
    }

    public static void solve() {
        for (; L <= 100; L++) {
            int sequenceSum = calc(L);

            if ((N - sequenceSum) % L == 0) {
                int start = (N - sequenceSum) / L;
                print(L, start);
                return;
            }
        }

        System.out.print(-1);
    }

    public static int calc(int L) {
        return (L * (L - 1)) / 2;
    }

    public static void print(int L, int x) {
        if (x < 0) {
            System.out.print(-1);
        }
        else {
            for (int i = 0; i < L; i++) {
                System.out.print(x + i + " ");
            }
        }
    }
}
