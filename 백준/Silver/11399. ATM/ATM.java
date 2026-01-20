import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            int sum = 0;

            for (int j = 0; j <= i; j++) {
                sum += nums[j];
            }

            result += sum;
        }

        System.out.print(result);
        br.close();
    }
}
