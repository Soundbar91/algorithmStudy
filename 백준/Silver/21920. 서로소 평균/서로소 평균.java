import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    static int N, X;
    static int[] nums;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        X = Integer.parseInt(br.readLine());

        for (int num : nums) {
            if (solve(X, num)) list.add(num);
        }

        System.out.print(result());
        br.close();
    }

    public static boolean solve(int n1, int n2) {
        while (n2 != 0) {
            int r = n1 % n2;

            n1 = n2;
            n2 = r;
        }

        return n1 == 1;
    }

    public static double result() {
        long result = 0L;

        for (int num : list) result += num;

        return (double) result / list.size();
    }
}
