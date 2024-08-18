import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        x = Integer.parseInt(br.readLine());

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int start = 0, end = arr.length - 1, count = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                count++;
                start++;
                end--;
            }
            else if (sum < x) start++;
            else end--;
        }

        return count;
    }
}
