import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static int[] nums;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            M = Integer.parseInt(br.readLine());
            nums = new int[M];

            System.out.print(solve());
        }

        br.close();
    }

    public static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append((M + 1) / 2).append('\n');

        List<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < M; i++) {
            if (i % 10 == 0) st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());

            list.add(value);
            Collections.sort(list);

            if (i % 2 == 0) {
                if (count == 9 || i == M - 1) {
                    sb.append(list.get(i / 2)).append('\n');
                    count = 0;
                }
                else {
                    sb.append(list.get(i / 2)).append(" ");
                    count++;
                }
            }
        }

        return sb.toString();
    }
}
