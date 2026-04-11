import java.io.*;
import java.util.*;

/**
 * 9237. 이장님 초대
 * 나무 묘목 n개 구입, 묘목 하나를 심는데 걸리는 시간은 1일
 */

public class Main {

    static int N;
    static int[] trees;
    static int[] days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        trees = new int[N];
        days = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);

        for (int i = 0; i < N; i++) {
            days[i] = (i + 1) + trees[N - i - 1];
        }

        Arrays.sort(days);

        System.out.print(days[N - 1] + 1);
        br.close();
    }
}
