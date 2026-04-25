import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] callTime = new int[3];
        int[] damage = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            callTime[i] = Integer.parseInt(st.nextToken());
            damage[i] = Integer.parseInt(st.nextToken());
        }

        int hp = Integer.parseInt(br.readLine());

        System.out.print(solve(callTime, damage, hp));
        br.close();
    }

    public static int solve(int[] callTime, int[] damage, int hp) {
        for (int d : damage) hp -= d;
        int cnt = 0;

        while (hp > 0) {
            cnt++;

            for (int i = 0; i < 3; i++) {
                if (cnt % callTime[i] == 0) hp -= damage[i];
            }
        }

        return cnt;
    }
}