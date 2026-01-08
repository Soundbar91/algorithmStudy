import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, Integer> names = new HashMap<>();
    static Map<Integer, String> indexs = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            names.put(name, i + 1);
            indexs.put(i + 1, name);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();

            if (Character.isDigit(input.charAt(0))) {
                int index = Integer.parseInt(input);
                sb.append(indexs.get(index)).append('\n');
            } else {
                sb.append(names.get(input)).append('\n');
            }
        }

        System.out.print(sb);
        br.close();
    }
}
