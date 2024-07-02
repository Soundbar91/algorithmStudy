import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    static int N;
    static int[] nums;
    static int[] operation;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        operation = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        solve(1, nums[0]);
        System.out.println(max);
        System.out.print(min);
        br.close();
    }

    public static void solve(int depth, int sum) {
        if (depth == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        else {
            for (int i = 0; i < 4; i++) {
                if (operation[i] > 0) {
                    operation[i]--;
                    solve(depth + 1, calculate(sum, nums[depth], i));
                    operation[i]++;
                }
            }
        }
    }

    public static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            default: return a / b;
        }
    }
}
