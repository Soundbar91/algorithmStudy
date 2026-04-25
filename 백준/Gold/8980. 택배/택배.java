import java.io.*;
import java.util.*;

public class Main {

    static int N, C, M, curWeight, result;
    static Queue<Box> queue = new PriorityQueue<>((a, b) -> {
        if (a.start == b.start) {
            return a.end - b.end;
        }
        return a.start - b.start;
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            queue.add(new Box(start, end, weight));
        }

        solve();
        br.close();
    }

    public static void solve() {
        Queue<Box> cur = new PriorityQueue<>((a, b) -> a.end - b.end);

        for (int i = 1; i <= N; i++) {
            while (!cur.isEmpty()) {
                if (cur.peek().end == i) {
                    curWeight -= cur.peek().weight;
                    result += cur.poll().weight;
                } else {
                    break;
                }
            }

            if (curWeight != C) {
                while (!queue.isEmpty()) {
                    if (queue.peek().start == i) {
                        if (C - curWeight < queue.peek().weight) {
                            cur.add(new Box(queue.peek().start, queue.peek().end, C - curWeight));
                            curWeight += C - curWeight;
                        } else {
                            cur.add(new Box(queue.peek().start, queue.peek().end, queue.peek().weight));
                            curWeight += queue.peek().weight;
                        }
                        queue.poll();
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.print(result);
    }

    public static class Box {
        int start;
        int end;
        int weight;

        public Box(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}