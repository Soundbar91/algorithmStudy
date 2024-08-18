import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        int[] result = solve();
        System.out.println(result[0] + " " + result[1]);
        br.close();
    }

    public static int[] solve() {
        int[] result = new int[2];
        int left = 0, right = arr.length - 1, memo = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (memo > Math.abs(sum)) {
                memo = Math.abs(sum);
                result[0] = arr[left];
                result[1] = arr[right];
                if (sum == 0) break;
            }
            if (sum < 0) left++;
            else right--;
        }

        return result;
    }
}
