import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Class> classes = new ArrayList<>();
    static Queue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classes.add(new Class(start, end));
        }

        solve();
        br.close();
    }

    public static void solve() {
        classes.sort(null);

        for (int i = 0; i < N; i++) {
            Class cur = classes.get(i);

            if (!queue.isEmpty() && cur.start >= queue.peek()) {
                queue.poll();
            }
            queue.add(cur.end);
        }

        System.out.print(queue.size());
    }

    public static class Class implements Comparable<Class> {
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}