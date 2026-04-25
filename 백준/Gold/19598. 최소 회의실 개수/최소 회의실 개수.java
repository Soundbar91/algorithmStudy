import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Meeting[] meetings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        meetings = new Meeting[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.print(solve());
    }

    public static int solve() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.sort(meetings);

        queue.add(meetings[0].end);

        for (int i = 1; i < N; i++) {
            if (queue.peek() <= meetings[i].start) queue.poll();
            queue.add(meetings[i].end);
        }

        return queue.size();
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
            if (start == o.start) return end - o.end;
            return start - o.start;
        }
    }
}
