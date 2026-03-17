import java.io.*;
import java.util.*;

public class Main {

    static int[] dp = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 100_000; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }

        System.out.print(dp[Integer.parseInt(br.readLine())]);
        br.close();
    }
}
