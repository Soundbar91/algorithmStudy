import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        for (int i = 0; i < N; i++) {
            if (solve(i, arr[i])) {
                result++;
            }
        }

        System.out.print(result);
        br.close();
    }

    public static boolean solve(int index, int value) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == value) {
                if (start == index) start++;
                else if (end == index) end--;
                else return true;
            }
            else if (sum > value) end--;
            else start++;
        }

        return false;
    }
}
