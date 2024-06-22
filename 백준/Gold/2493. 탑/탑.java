import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static int[] tower;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tower = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        result = new int[N];

        solve();
        br.close();
    }

    public static void solve() {
        Stack<int[]> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= tower[i]) {
                result[stack.pop()[1]] = i + 1;
            }
            stack.push(new int[] {tower[i], i});
        }

        IntStream.range(0, N).mapToObj(i -> result[i] + " ").forEach(System.out::print);
    }
}
