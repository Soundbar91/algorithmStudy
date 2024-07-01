import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static List<Egg> eggs = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            eggs.add(new Egg(S, W));
        }

        solve(0, 0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int depth, int breakEgg) {
        if (depth == N) {
            update();
            return ;
        }
        Egg cur = eggs.get(depth);
        int curS = cur.S;

        if (breakEgg == N - 1 || curS <= 0) solve(depth + 1, breakEgg);
        else {
            for (int i = 0; i < N; i++) {
                if (i == depth) continue;

                Egg next = eggs.get(i);
                int nextS = next.S;
                if (nextS <= 0) continue;

                cur.S -= next.W;
                next.S -= cur.W;

                int temp = breakEgg;
                if (cur.S <= 0) temp++;
                if (next.S <= 0) temp++;

                solve(depth + 1, temp);

                cur.S += next.W;
                next.S += cur.W;
            }
        }
    }

    public static void update() {
        int count = 0;
        for (Egg egg : eggs) if (egg.S <= 0) count++;
        result = Math.max(result, count);
    }

    public static class Egg {
        int S;
        int W;

        public Egg(int s, int w) {
            S = s;
            W = w;
        }
    }
}
