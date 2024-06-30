import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solve(1);
        br.close();
    }

    public static void solve(int startValue) {
        if (list.size() == M) {
            for (int value : list) System.out.print(value + " ");
            System.out.println();
        }
        else {
            for (int i = startValue; i <= N; i++) {
                list.add(i);
                solve(i);
                list.remove(list.size() - 1);
            }
        }
    }
}
