import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long A;
    static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.print(solve(B, 0));
    }

    public static long solve(long value, long depth) {
        if (value == A) return depth + 1;
        if (value < A) return -1;

        if (value % 10 == 1) return solve(value / 10, depth + 1);
        else if (value % 2 == 0) return solve(value / 2, depth + 1);
        else return -1;
    }
}
