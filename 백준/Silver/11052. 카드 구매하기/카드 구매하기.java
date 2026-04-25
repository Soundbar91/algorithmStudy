import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[1001];
        for (int i = 1; i <= n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[i], dp[i - j] + numArr[j]);
            }
        }

        System.out.print(dp[n]);

    }
}
