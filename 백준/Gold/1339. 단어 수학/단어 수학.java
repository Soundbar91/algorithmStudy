import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static List<String> strings = new ArrayList<>();
    static int[] weights = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            strings.add(br.readLine());
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        for (String string : strings) {
            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                weights[c - 'A'] += (int)Math.pow(10, (string.length() - i - 1));
            }
        }

        return sum();
    }

    public static int sum() {
        int sum = 0, weight = 9, len = 25;
        Arrays.sort(weights);

        while (weights[len] != 0) {
            sum += weights[len] * weight--;
            len--;
        }

        return sum;
    }
}
