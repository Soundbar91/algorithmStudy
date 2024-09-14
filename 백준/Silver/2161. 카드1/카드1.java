import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        solve();
        br.close();
    }

    public static void solve() {
        int count = 0;

        while (!deque.isEmpty()) {
            if (count % 2 == 0)
                System.out.print(deque.removeFirst() + " ");
            else
                deque.addLast(deque.removeFirst());

            count++;
        }
    }
}
