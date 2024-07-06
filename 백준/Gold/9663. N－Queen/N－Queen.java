import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, result;
    static int[] cols;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cols = new int[N];

        solve(0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int row) {
        if (row == N) {
            result++;
            return ;
        }
        else {
            for (int i = 0; i < N; i++) {
                cols[row] = i;
                if (valid(row)) solve(row + 1);
            }
        }
    }

    public static boolean valid(int row) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == cols[row]
                    || Math.abs(cols[i] - cols[row]) == row - i)
                return false;
        }
        return true;
    }
}
