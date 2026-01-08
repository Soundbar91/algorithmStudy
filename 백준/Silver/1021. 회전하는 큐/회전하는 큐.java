import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] nums;
    static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            deque.add(i + 1);
        }

        nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        br.close();
    }

    public static void solve() {
        int result = 0;

        for (int i = 0; i < M; i++) {
            int num = nums[i];
            int index = deque.indexOf(num);
            int mid = 0;

            if (deque.size() % 2 == 0) {
                mid = deque.size() / 2 - 1;
            } else {
                mid = deque.size() / 2;
            }

            if (index > mid) {
                for (int j = 0; j < deque.size() - index; j++) {
                    result++;
                    deque.offerFirst(deque.pollLast());
                }
            } else {
                for (int j = 0; j < index; j++) {
                    result++;
                    deque.offerLast(deque.pollFirst());
                }
            }
            deque.pollFirst();
        }

        System.out.print(result);
    }
}
