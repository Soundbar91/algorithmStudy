import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int result;
    static Set<String> stringSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        while (N-- > 0) {
            String input = br.readLine();
            stringSet.add(input);
        }

        while (M-- > 0) {
            String input = br.readLine();
            if (stringSet.contains(input)) result++;
        }

        System.out.print(result);
        br.close();
    }
}
