import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static Queue<Integer> positive = new PriorityQueue<>((a, b) -> b - a);
    static Queue<Integer> negative = new PriorityQueue<>((a, b) -> a - b);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value <= 0) {
                negative.add(value);
            } else {
                positive.add(value);
            }
        }

        solve();
        br.close();
    }

    public static void solve() {
        while (!negative.isEmpty()) {
            int cur = negative.poll();
            if (negative.isEmpty()) {
                result += cur;
                break;
            }

            result += (cur * negative.poll());
        }

        while (!positive.isEmpty()) {
            int cur = positive.poll();
            if (positive.isEmpty()) {
                result += cur;
                break;
            }
            int next = positive.peek();


            int plus = cur + next;
            int multiply = cur * next;

            if (plus > multiply) {
                result += cur;
                result += positive.poll();
            } else {
                result += (cur * positive.poll());
            }
        }

        System.out.print(result);
    }
}