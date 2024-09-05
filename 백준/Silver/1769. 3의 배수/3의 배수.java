import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String X = br.readLine();

        solve(X, 0);
    }

    public static void solve(String X, int depth) {
        if (X.length() == 1) {
            int value = Integer.parseInt(X);
            System.out.println(depth);
            System.out.print(value % 3 == 0 ? "YES" : "NO");
        }
        else {
            int sum = 0;

            for (int i = 0; i < X.length(); i++) {
                char c = X.charAt(i);
                sum += c - '0';
            }

            solve(String.valueOf(sum), depth + 1);
        }
    }
}
