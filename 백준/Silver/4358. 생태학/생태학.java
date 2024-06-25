import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        String tree;

        while ((tree = br.readLine()) != null && !tree.isEmpty()) {
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            count++;
        }
        
        Set<String> keySet = new TreeSet<>(map.keySet());
        StringBuilder sb = new StringBuilder();

        for (String key : keySet) {
            double percentage = (double) map.get(key) / count * 100;
            sb.append(key).append(' ').append(String.format("%.4f", percentage)).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
