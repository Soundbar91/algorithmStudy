import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int gcd = solve(A, B);
        System.out.print(gcd + "\n" + (A * B) / gcd);
        br.close();
    }

    public static int solve(int A, int B) {
        while (B != 0) {
            int r = A % B;

            A = B;
            B = r;
        }

        return A;
    }
}
