import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        height = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print(solve());
    }

    public static int solve() {
        int[] temp = new int[N - 1];
        for (int i = 0; i < N - 1; i++) temp[i] = height[i + 1] - height[i];
        Arrays.sort(temp);

        int result = 0;
        int len = height.length - K;

        for (int i = 0; i < len; i++) result += temp[i];

        return result;
    }
}
