import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static String A, B;
    static List<long[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken();
        B = st.nextToken();

        solve();
        br.close();
    }

    public static void solve() {
        char[] left = A.toCharArray();
        char[] right = B.toCharArray();

        int indexLeft = find(left) + 1, indexRight = find(right) + 1;

        for (int i = indexLeft; i <= 36; i++) {
            long leftSum = calc(left, i);

            for (int j = indexRight; j <= 36; j++) {
                if (i == j) continue;

                long rightSum = calc(right, j);
                if (leftSum == rightSum) list.add(new long[]{leftSum, i, j});
            }
        }

        print();
    }

    public static long calc(char[] arr, long weight) {
        long index = 1, result = 0L;

        for (int j = arr.length - 1; j >= 0; j--) {
            long num = arr[j] >= 'a' ?
                    arr[j] - 'a' + 10 : arr[j] - '0';

            result += (num * index);
            index *= weight;
        }

        return result;
    }

    public static int find(char[] arr) {
        int result = 0;

        for (char c : arr) {
            int num = c >= 'a' ? c - 'a' + 10 : c - '0';
            result = Math.max(result, num);
        }

        return result;
    }

    public static void print() {
        if (list.isEmpty()) System.out.print("Impossible");
        else if (list.size() >= 2) System.out.print("Multiple");
        else {
            long[] result = list.get(0);
            System.out.print(result[0] + " " + result[1] + " " + result[2]);
        }
    }
}
