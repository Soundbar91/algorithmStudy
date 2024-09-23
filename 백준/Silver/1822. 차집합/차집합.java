import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int A, B;
    static Set<Integer> setA = new HashSet<>(), setB = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (A-- > 0) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        while (B-- > 0) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        solve();
        br.close();
    }

    public static void solve() {
        List<Integer> result = new ArrayList<>();

        for (int i : setA) {
            if (!setB.contains(i)) result.add(i);
        }

        if (result.isEmpty())
            System.out.print("0");
        else {
            result.sort(null);

            System.out.println(result.size());
            result.forEach(v -> System.out.print(v + " "));
        }
    }
}
