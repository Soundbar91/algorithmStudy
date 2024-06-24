import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<String> intKey = new ArrayList<>();
    static Map<String, Integer> stringKey = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            intKey.add(str);
            stringKey.put(str, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (Character.isDigit(input.charAt(0))) {
                sb.append(intKey.get(Integer.parseInt(input) - 1)).append('\n');
            } else {
                sb.append(stringKey.get(input)).append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }
}
