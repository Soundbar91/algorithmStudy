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
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1]);
        br.close();
    }

    public static int[] solve() {
        int[] result = new int[2];
        int left = 0, right = arr.length - 1, memo = Integer.MAX_VALUE;

        while (left < right) {
            int sum = Math.abs(arr[left] + arr[right]);

            if (memo > sum) {
                memo = sum;
                result[0] = arr[left];
                result[1] = arr[right];
            }
            if (Math.abs(arr[left]) > arr[right]) left++;
            else right--;
        }

        return result;
    }
}
