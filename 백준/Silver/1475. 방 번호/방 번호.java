import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] count = new int[10];

        for (char c : N.toCharArray()) {
            count[c - '0']++;
        }

        count[6] = (count[6] + count[9] + 1) / 2;
        count[9] = 0;

        int result = 0;
        for (int i = 0; i < 9; i++) {
            result = Math.max(result, count[i]);
        }

        System.out.print(result);
        br.close();
    }
}
