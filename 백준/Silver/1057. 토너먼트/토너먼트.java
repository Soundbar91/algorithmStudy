import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int count = 0;

        while (x != y) {
            x = x / 2 + x % 2;
            y = y / 2 + y % 2;
            count++;
        }

        return count;
    }
}
