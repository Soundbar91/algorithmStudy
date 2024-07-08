import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        System.out.print(solve(N, B));
        br.close();
    }

    public static long solve(String N, int B) {
        char[] chars = N.toCharArray();
        long result = 0L;

        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            int weight = (int) Math.pow(B, chars.length - 1 - i);

            if (c >= 'A') result += (long) (10 + (c - 'A')) * weight;
            else result += (long) (c - '0') * weight;
        }

        return result;
    }
}
