import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static Item[] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        items = new Item[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int[] dp = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = K; j >= items[i].weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i].weight] + items[i].value);
            }
        }

        return dp[K];
    }

    public static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
