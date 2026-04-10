import java.io.*;
import java.util.*;

/**
 * 1270. 전쟁 - 땅따먹기
 * 적군을 혼란시키기 위해서 우리 나라의 군대라는걸 표시하지 않고, 군대의 번호로 표시
 * 어느 땅에서 한 번호의 군대의 병사가 절반을 초과한다면 그 땅은 그 번호의 군대의 지배하에 놓이게 됨
 *
 * 절반을 넘긴다.
 * 1 1 1 1 2 2 2 3 3 3
 */

public class Main {

    static int n, T;
    static Map<Long, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            T = Integer.parseInt(st.nextToken());
            map = new HashMap<>();
            for (int j = 0; j < T; j++) {
                long N = Long.parseLong(st.nextToken());
                int count = map.getOrDefault(N, 0);
                map.put(N, count + 1);
            }

            sb.append(solve()).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    public static String solve() {
        int mid = T / 2 + 1;

        for (long key : map.keySet()) {
            if (map.get(key) >= mid) {
                return String.valueOf(key);
            }
        }

        return "SYJKGW";
    }
}
