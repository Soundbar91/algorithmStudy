import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer> list = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solve();
        System.out.print(sb);
        br.close();
    }

    public static void solve() {
        if (list.size() == M) {
            for (int value : list) sb.append(value).append(" ");
            sb.append('\n');
        }
        else {
            for (int i = 1; i <= N; i++) {
                list.add(i);
                solve();
                list.remove(list.size() - 1);
            }
        }
    }
}
