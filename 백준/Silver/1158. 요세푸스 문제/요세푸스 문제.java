import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        solve(list, K);
        br.close();
    }

    public static void solve(LinkedList<Integer> list, int K) {
        StringBuilder sb = new StringBuilder().append('<');
        int index = 0;

        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            sb.append(list.remove(index)).append(list.isEmpty() ? '>' : ", ");
        }

        System.out.print(sb);
    }
}
