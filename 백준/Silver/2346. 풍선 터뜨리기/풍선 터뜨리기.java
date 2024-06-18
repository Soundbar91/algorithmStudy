import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        LinkedList<Balloon> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(new Balloon(i, nums[i - 1]));

        solve(list);
    }

    public static void solve(LinkedList<Balloon> list) {
        StringBuilder sb = new StringBuilder();
        int cur = 0;

        while (true) {
            Balloon balloon = list.remove(cur);
            sb.append(balloon.index).append(' ');

            if (list.isEmpty()) break;

            int steps = balloon.next;
            if (steps > 0) {
                cur = (cur + (steps - 1)) % list.size();
            } else {
                cur = (cur + steps) % list.size();
                if (cur < 0) {
                    cur += list.size();
                }
            }
        }

        System.out.print(sb);
    }

    public static class Balloon {
        int index;
        int next;

        public Balloon(int index, int next) {
            this.index = index;
            this.next = next;
        }
    }
}
