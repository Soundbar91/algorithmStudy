import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lines.add(new Line(start, end));
        }

        solve();
        br.close();
    }

    public static void solve() {
        Queue<Line> queue = new LinkedList<>();
        lines.sort(null);
        long result = 0;

        for (int i = 0; i < N; i++) {
            Line line = lines.get(i);

            if (queue.isEmpty()) {
                queue.add(line);
            } else {
                if (queue.peek().end >= line.start) {
                    queue.peek().setEnd(Math.max(queue.peek().end, line.end));
                } else {
                    result += queue.poll().calcLen();
                    queue.add(line);
                }
            }
        }

        while (!queue.isEmpty()) {
            result += queue.poll().calcLen();
        }

        System.out.println(result);
    }

    public static class Line implements Comparable<Line> {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public long calcLen() {
            return Math.abs(this.end - this.start);
        }

        @Override
        public int compareTo(Line o) {
            if (this.start == o.start) {
                return o.end - this.end;
            }
            return this.start - o.start;
        }
    }
}