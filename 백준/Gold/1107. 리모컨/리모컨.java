import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, len = 6, result = 987654321;
    static StringBuilder sb = new StringBuilder();
    static boolean[] broken = new boolean[10];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if (M != 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        do {
            permutation(0);
        } while (--len != 0);
        print();
    }

    public static void permutation(int index) {
        if (index == len) {
            check();
            return ;
        }

        for (int i = 0; i < 10; i++) {
            if (!broken[i]) {
                sb.append(i);
                permutation(index + 1);
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }

    public static void check() {
        result = Math.min(result, Math.abs(N - Integer.parseInt(sb.toString())) + len);
    }

    public static void print() {
        if (N == 100) {
            System.out.print(0);
        }
        else {
            System.out.print(Math.min(Math.abs(100 - N), result));
        }
    }
}
