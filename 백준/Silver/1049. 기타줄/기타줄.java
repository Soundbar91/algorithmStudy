import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static List<Integer> sixSet = new ArrayList<>();
    static List<Integer> oneSet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int sixPrice = Integer.parseInt(st.nextToken());
            int onePrice = Integer.parseInt(st.nextToken());

            sixSet.add(sixPrice);
            oneSet.add(onePrice);
        }

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        sixSet.sort(null);
        oneSet.sort(null);

        int minSixPrice = sixSet.get(0);
        int minOnePrice = oneSet.get(0);

        int onlyOne = minOnePrice * N;
        int onlySix = minSixPrice * (N % 6 == 0 ? N / 6 : N / 6 + 1);
        int oneAndSix = minSixPrice * (N / 6) + minOnePrice * (N % 6);

        return Math.min(onlyOne, Math.min(onlySix, oneAndSix));
    }
}
