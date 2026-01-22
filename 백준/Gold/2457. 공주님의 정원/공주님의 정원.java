import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int start = calcDay(3, 1);
    static int end = calcDay(11, 30);
    static List<Flower> flowers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int startDay = calcDay(sm, sd);
            int endDay = calcDay(em, ed);

            if (endDay <= start || startDay > end) continue;

            flowers.add(new Flower(startDay, endDay));
        }

        solve();
        br.close();
    }

    public static void solve() {
        flowers.sort(null);

        int currentEnd = start;
        int count = 0;
        int index = 0;

        while (currentEnd <= end) {
            int nextEnd = currentEnd;

            while (index < flowers.size() && flowers.get(index).start <= currentEnd) {
                nextEnd = Math.max(nextEnd, flowers.get(index).end);
                index++;
            }

            if (nextEnd == currentEnd) {
                System.out.print(0);
                System.exit(0);
            }

            count++;
            currentEnd = nextEnd;
        }

        System.out.print(count);
    }

    public static int calcDay(int month, int day) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += days[i];
        }
        return sum + day;
    }

    static class Flower implements Comparable<Flower> {
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) {
                return o.end - this.end;
            }
            return this.start - o.start;
        }
    }
}