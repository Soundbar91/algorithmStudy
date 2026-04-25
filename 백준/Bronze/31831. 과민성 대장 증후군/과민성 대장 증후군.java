import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] stress;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        stress = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) stress[i] = Integer.parseInt(st.nextToken());

        solve();
    }

    public static void solve() {
        long temp = 0;

        for (int i = 0; i < N; i++) {
            temp += stress[i];
            if (temp >= M) result++;
            if (temp < 0) temp = 0;
        }

        System.out.print(result);
    }
}
