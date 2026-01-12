import java.io.*;
import java.util.*;

public class Main {

    static int K, L, count;
    static Map<String, Integer> map = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 0; i < L; i++) {
            String studentNumber = br.readLine();
            map.remove(studentNumber);
            map.put(studentNumber, i);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append('\n');
            if (++count == K) {
                break;
            }
        }

        System.out.print(sb);
        br.close();
    }
}
