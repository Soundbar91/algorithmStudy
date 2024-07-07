import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solve();
        br.close();
    }

    public static void solve() {
        int work = 0;
        int tired = 0;

        for (int i = 0; i < 24; i++) {
            if (tired + A <= M) {
                work += B;
                tired += A;
            }
            else {
                tired -= C;
                if (tired < 0) tired = 0;
            }
        }

        System.out.print(work);
    }
}
