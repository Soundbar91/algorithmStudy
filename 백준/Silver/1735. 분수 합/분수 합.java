import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] n1 = new int[2];
    static int[] n2 = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n1[0] = Integer.parseInt(st.nextToken());
        n1[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n2[0] = Integer.parseInt(st.nextToken());
        n2[1] = Integer.parseInt(st.nextToken());

        long[] result = solve();
        System.out.print(result[0] + " " + result[1]);
        br.close();
    }

    public static long[] solve() {
        long[] result = new long[2];

        result[0] = (long)n1[0] * n2[1] + (long)n1[1] * n2[0];
        result[1] = (long)n1[1] * n2[1];

        long gcd = gcd(result[0], result[1]);

        result[0] /= gcd;
        result[1] /= gcd;

        return result;
    }

    public static long gcd(long p, long q) {
        if (q == 0) return p;
        return gcd(q, p % q);
    }
}
