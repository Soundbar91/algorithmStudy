import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            String[] str = new String[N];
            for (int i = 0; i < N; i++) str[i] = st.nextToken();

            if (N >= 33) sb.append(0).append('\n');
            else sb.append(solve(str)).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static int solve(String[] str) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                for (int k = j + 1; k < str.length; k++) {
                    int cnt = 0;

                    for (int l = 0; l < 4; l++) {
                        cnt += str[i].charAt(l) != str[j].charAt(l) ? 1 : 0;
                        cnt += str[i].charAt(l) != str[k].charAt(l) ? 1 : 0;
                        cnt += str[j].charAt(l) != str[k].charAt(l) ? 1 : 0;
                    }

                    result = Math.min(cnt, result);
                }
            }
        }

        return result;
    }
}
