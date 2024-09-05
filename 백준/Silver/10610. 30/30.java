import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static char[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = br.readLine().toCharArray();

        Arrays.sort(nums);
        if (nums[0] != '0') {
            System.out.println(-1);
            System.exit(0);
        }

        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i] - '0';
            sb.append(nums[i]);
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        else
            System.out.print(sb);

        br.close();
    }
}
