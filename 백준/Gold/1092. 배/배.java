import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer> crane = new ArrayList<>();
    static List<Integer> box = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) crane.add(Integer.parseInt(st.nextToken()));

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) box.add(Integer.parseInt(st.nextToken()));

        System.out.print(solve());
        br.close();
    }

    public static long solve() {
        box.sort(Collections.reverseOrder());
        crane.sort(Collections.reverseOrder());
        if (crane.get(0) < box.get(0)) return -1;

        long result = 0;

        while (!box.isEmpty()) {
            for (int i = 0; i < crane.size(); i++) {
                boolean flag = false;

                for (int j = 0; j < box.size(); j++) {
                    if (crane.get(i) >= box.get(j)) {
                        box.remove(j);
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    crane.remove(i);
                    i--;
                }
            }
            result++;
        }

        return result;
    }
}
