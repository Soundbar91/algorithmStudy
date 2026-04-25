import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int r;   // 행
    static int c;   // 열
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        solved((int) Math.pow(2, N), r, c);
    }

    public static void solved(int size, int r, int c) {
        if (size == 1) {
            System.out.print(result);
            System.exit(0);
        }

        else {
            int n = size / 2;

            if (r < n && c < n) {
                solved(n, r, c);
            }
            else if (r < n && c < n + n) {
                result += n * n;
                solved(n, r, c - n);
            }
            else if (r < n + n && c < n) {
                result += n * n * 2;
                solved(n, r - n, c);
            }
            else {
                result += n * n * 3;
                solved(n, r - n, c - n);
            }
        }
    }
}
