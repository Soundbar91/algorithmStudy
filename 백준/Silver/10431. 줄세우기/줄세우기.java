import java.io.*;
import java.util.*;

public class Main {

    static int P, T, result;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        P = Integer.parseInt(st.nextToken());

        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());

            T = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            result = 0;

            for (int i = 0; i < 20; i++) {
                int value = Integer.parseInt(st.nextToken());

                int index = -1;
                for (int j = 0; j < list.size(); j++) {
                    if (value < list.get(j)) {
                        index = j;
                        break;
                    }
                }

                if (index == -1) {
                    list.add(value);
                } else {
                    result += (list.size() - index);
                    list.add(index, value);
                    list.sort(null);
                }
            }

            sb.append(T).append(" ").append(result).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
