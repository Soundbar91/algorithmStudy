import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] nums;
    static boolean[] visited;
    static Map<Integer, Queue<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[K + 1];
        visited = new boolean[K + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = map.getOrDefault(nums[i], new PriorityQueue<>());
            queue.add(i);
            map.put(nums[i], queue);
        }

        solve();
        br.close();
    }

    public static void solve() {
        List<Integer> list = new ArrayList<>();
        int result = 0;

        for (int i = 1; i <= K; i++) {
            int num = nums[i];
            Queue<Integer> queue = map.get(num);

            if (visited[num]) {
                queue.poll();
                continue;
            }

            if (list.size() == N) {
                int value = -1, index = -1;
                boolean found = false;

                for (int j = 0; j < list.size(); j++) {
                    if (map.get(list.get(j)).isEmpty()) {
                        visited[list.get(j)] = false;
                        list.remove(j);
                        result++;
                        found = true;
                        break;
                    }

                    if (value < map.get(list.get(j)).peek()) {
                        value = map.get(list.get(j)).peek();
                        index = j;
                    }
                }

                if (!found) {
                    visited[list.get(index)] = false;
                    list.remove(index);
                    result++;
                }
            }

            queue.poll();
            list.add(num);
            visited[num] = true;
        }

        System.out.print(result);
    }
}