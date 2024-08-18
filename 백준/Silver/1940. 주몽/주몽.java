import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        int start = 0, end = arr.length - 1, count = 0;
        Arrays.sort(arr);

        while (start < end) {

            int sum = arr[start] + arr[end];

            if (sum == M) {
                count++;
                start++;
                end--;
            }
            else if (sum < M) start++;
            else end--;

        }

        return count;
    }

}
