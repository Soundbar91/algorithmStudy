import java.io.*;
import java.util.*;

public class Main {

    static int C, N;
    static Info[] infos;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        infos = new Info[N];
        dp = new int[C + 101];
        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            infos[i] = new Info(cost, people);
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int i = 0; i < N; i++) {
            Info info = infos[i];

            for (int j = info.people; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - info.people] + info.cost);
            }
        }

        for (int i = C; i < dp.length; i++) {
            dp[C] = Math.min(dp[C], dp[i]);
        }

        System.out.print(dp[C]);
    }

    public static class Info {
        int cost;
        int people;

        public Info(int cost, int people) {
            this.cost = cost;
            this.people = people;
        }
    }
}
