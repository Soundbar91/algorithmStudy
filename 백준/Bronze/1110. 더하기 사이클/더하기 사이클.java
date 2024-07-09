import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.print(solve());
    }

    public static int solve() {
        int count = 0;
        int copy = N;

        do {
            N = ((N % 10) * 10) + ((N / 10 + N % 10) % 10);
            count++;
        } while (N != copy);

        return count;
    }
}
