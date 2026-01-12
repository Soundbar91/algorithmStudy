import java.io.*;
import java.util.*;

public class Main {

    static int T, n, result;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            map = new HashMap<>();

            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                String value = st.nextToken();
                String key = st.nextToken();

                Integer values = map.getOrDefault(key, 0);
                map.put(key, values + 1);
            }

            result = 1;

            for (int values : map.values()) {
                result *= (values + 1);
            }
            sb.append(result - 1).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
