import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static final int MAX = 98765;
    static int K, M;
    static boolean[] nums;
    static boolean[] visited = new boolean[10];
    static List<Integer> decimal = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static Set<Integer> mulSet = new HashSet<>();
    static Set<Integer> sumSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        makeNum(0, "");
        makeDecimal();
        calc();

        int result = 0;

        for (int n : list) {
            if (!sumSet.contains(n)) continue;
            while (n % M == 0) n /= M;
            if (mulSet.contains(n)) result++;
        }

        return result;
    }

    public static void makeNum(int depth, String num) {
        if (depth == K) {
            list.add(Integer.parseInt(num));
        }
        else {
            for (int i = 0; i < visited.length; i++) {
                if (depth == 0 && i == 0) continue;
                if (visited[i]) continue;

                visited[i] = true;
                makeNum(depth + 1, num + i);
                visited[i] = false;
            }
        }
    }

    public static void makeDecimal() {
        nums = new boolean[MAX + 1];

        for (int i = 2; i <= MAX; i++) {
            if (nums[i]) continue;
            decimal.add(i);
            for (int j = i * 2; j <= MAX; j += i) {
                nums[j] = true;
            }
        }
    }

    public static void calc() {
        for (int i = 0; i < decimal.size(); i++) {
            for (int j = 0; j < decimal.size(); j++) {
                int n1 = decimal.get(i);
                int n2 = decimal.get(j);
                long mul = (long) n1 * n2;

                if (mul <= MAX) mulSet.add((int)mul);
                if (n1 != n2) {
                    int sum = n1 + n2;
                    if (sum <= MAX) sumSet.add(sum);
                }
            }
        }
    }
}
