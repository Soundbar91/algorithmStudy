import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            long result = 0L;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    result += solve(nums[i], nums[j]);
                }
            }

            System.out.println(result);
        }

        br.close();
    }

    public static long solve(int n1, int n2) {
        while (n2 != 0) {
            int r = n1 % n2;

            n1 = n2;
            n2 = r;
        }

        return n1;
    }
}
