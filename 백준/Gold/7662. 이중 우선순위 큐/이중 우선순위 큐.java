import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());

                String order = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (order.equals("I")) map.put(value, map.getOrDefault(value, 0) + 1);
                else {
                    if (map.isEmpty()) continue;

                    int temp = value == 1 ? map.lastKey() : map.firstKey();
                    if (map.put(temp, map.get(temp) - 1) == 1) map.remove(temp);
                }
            }

            if (map.isEmpty()) System.out.println("EMPTY");
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }

        br.close();
    }
}
