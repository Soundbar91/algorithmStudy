import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] switches;
    static int people;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        switches = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            int bool = Integer.parseInt(st.nextToken());
            if (bool == 1) switches[i] = true;
        }

        people = Integer.parseInt(br.readLine());

        while (people-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            list.add(new int[]{sex, num});
        }

        solve();
        br.close();
    }

    public static void solve() {
        for (int[] i : list) {
            if (i[0] == 1) man(i);
            else woman(i);
        }
        printResult();
    }

    public static void man(int[] info) {
        for (int i = info[1]; i < switches.length; i += info[1]) {
            switches[i] = !switches[i];
        }
    }

    public static void woman(int[] info) {
        switches[info[1]] = !switches[info[1]];

        for (int i = 1; i < switches.length; i++) {
            if (info[1] - i <= 0 || info[1] + i >= switches.length) break;

            if (switches[info[1] + i] == switches[info[1] - i]) {
                switches[info[1] + i] = !switches[info[1] + i];
                switches[info[1] - i] = !switches[info[1] - i];
            }
            else break;
        }
    }

    public static void printResult() {
        for (int i = 1; i < switches.length; i++) {
            System.out.print(switches[i] ? "1 " : "0 ");
            if (i % 20 == 0) System.out.println();
        }
    }
}
