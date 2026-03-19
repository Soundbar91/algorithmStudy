import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {

    static String n;
    static BigDecimal[] dp = new BigDecimal[251];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0] = BigDecimal.valueOf(1);
        dp[1] = BigDecimal.valueOf(1);
        dp[2] = BigDecimal.valueOf(3);

        for (int i = 3; i <= 250; i++) {
            dp[i] = (dp[i - 2].multiply(BigDecimal.valueOf(2)).add(dp[i - 1]));
        }

        while ((n = br.readLine()) != null) {
            int N = Integer.parseInt(n);
            System.out.println(dp[N]);
        }

        br.close();
    }
}
