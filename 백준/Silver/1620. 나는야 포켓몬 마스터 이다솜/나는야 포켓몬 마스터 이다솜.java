import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static Map<Integer, String> intKey = new HashMap<>();
    static Map<String, Integer> stringKey = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            intKey.put(i + 1, str);
            stringKey.put(str, i + 1);
        }

        while (M-- > 0) {
            String input = br.readLine();

            try {
                int value = Integer.parseInt(input);
                sb.append(intKey.get(value)).append('\n');

            } catch (NumberFormatException e) {
                sb.append(stringKey.get(input)).append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }
}
