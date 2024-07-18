import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int N;
    static int[] nums;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            solve(i, i);
            visited[i] = false;
        }

        list.sort(null);
        System.out.println(list.size());
        list.forEach(System.out::println);
        br.close();
    }

    public static void solve(int cur, int end) {
        if (!visited[nums[cur]]) {
            visited[nums[cur]] = true;
            solve(nums[cur], end);
            visited[nums[cur]] = false;
        }
        if (nums[cur] == end) list.add(end);
    }
}
