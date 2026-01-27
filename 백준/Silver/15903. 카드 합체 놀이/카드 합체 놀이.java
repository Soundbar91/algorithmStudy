import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static long result;
    static Queue<Long> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long x = queue.poll();
            long y = queue.poll();

            queue.add(x + y);
            queue.add(x + y);
        }

        while (!queue.isEmpty()) {
            result += queue.poll();
        }

        System.out.print(result);
        br.close();
    }
}