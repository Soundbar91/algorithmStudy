import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static Map<String, String> passwordMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            passwordMap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            sb.append(passwordMap.get(br.readLine())).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
