import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(S, W);
        }

        solve(0, 0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int depth, int breakEgg) {
        if (depth == N) {
            result = Math.max(result, breakEgg);
            return;
        }

        Egg cur = eggs[depth];

        if (cur.S <= 0 || breakEgg == N - 1) {
            solve(depth + 1, breakEgg);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i == depth || eggs[i].S <= 0) continue;

            Egg next = eggs[i];

            cur.S -= next.W;
            next.S -= cur.W;

            int newBreakEgg = breakEgg;
            if (cur.S <= 0) newBreakEgg++;
            if (next.S <= 0) newBreakEgg++;

            solve(depth + 1, newBreakEgg);

            cur.S += next.W;
            next.S += cur.W;
        }
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
