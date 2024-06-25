import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static int count;
    static String tree;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            count++;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(null);

        for (String key : keySet) {
            System.out.println(key + ' ' + String.format("%.4f", (double)map.get(key) / count * 100));
        }
        br.close();
    }
}
