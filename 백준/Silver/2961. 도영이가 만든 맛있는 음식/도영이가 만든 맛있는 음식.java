import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    // acidity : 신맛, acerbity : 쓴맛
    static int result = Integer.MAX_VALUE, N;
    static Food[] foods;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        foods = new Food[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int acid = Integer.parseInt(st.nextToken());
            int acer = Integer.parseInt(st.nextToken());

            foods[i] = new Food(acid, acer);
        }

        solve(0, 1, 0);
        System.out.print(result);
        br.close();
    }

    public static void solve(int depth, int totalAcid, int totalAcer) {
        if (depth == N) {
            if (totalAcid == 1 && totalAcer == 0) return ;
            result = Math.min(result, Math.abs(totalAcid - totalAcer));
        }
        else {
            Food food = foods[depth];
            solve(depth + 1, totalAcid, totalAcer);
            solve(depth + 1, totalAcid * food.acidity, totalAcer + food.acerbity);
        }
    }

    public static class Food {
        int acidity;
        int acerbity;

        public Food(int acidity, int acerbity) {
            this.acidity = acidity;
            this.acerbity = acerbity;
        }
    }
}
