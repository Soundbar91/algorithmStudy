import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, K;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).sorted().toArray();

        System.out.print(solve());
        br.close();
    }

    public static int solve() {
        List<Integer> list = new ArrayList<>();
        int index = nums.length - 1;
        int result = 0;

        while (K-- > 0) {
            list.add(nums[index--]);
        }

        for (int i = 0; i < list.size(); i++) {
            result += (list.get(i) - i);
        }

        return result;
    }
}
