import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static String solve() {
        int count = 0;

        while (N > 3) {
            N -= 3;
            count++;
        }

        if (N == 0) return count % 2 != 0 ? "CY" : "SK";

        while (N > 0) {
            N -= 1;
            count++;
        }

        return count % 2 != 0 ? "CY" : "SK";
    }
}
