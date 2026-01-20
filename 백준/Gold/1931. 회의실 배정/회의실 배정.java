import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Stack<Meeting> stack = new Stack<>();
    static Queue<Meeting> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            queue.add(new Meeting(start, end));
        }

        solve();
        br.close();
    }

    public static void solve() {
        while (!queue.isEmpty()) {
            Meeting cur = queue.poll();

            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                Meeting prev = stack.peek();

                if (prev.end <= cur.start) {
                    stack.push(cur);
                }
            }
        }

        System.out.print(stack.size());
    }

    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}