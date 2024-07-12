import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int n = N;

        while (true) {
            if (valid(n)) {
                if (solve(String.valueOf(n))) {
                    System.out.print(n);
                    System.exit(0);
                }
            }
            n++;
        }
    }

    public static boolean solve(String n) {
        int left = 0, right = n.length() - 1;

        while (left <= right) {
            if (n.charAt(left++) != n.charAt(right--)) return false;
        }

        return true;
    }

    public static boolean valid(int num) {
        if (num == 1) return false;
        if (num == 2) return true;

        return IntStream.iterate(2, i -> i <= Math.sqrt(num), i -> i + 1).noneMatch(i -> num % i == 0);
    }
}
