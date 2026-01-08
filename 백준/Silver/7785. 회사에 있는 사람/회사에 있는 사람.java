import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();

            if (command.equals("enter")) {
                set.add(name);
            } else {
                set.remove(name);
            }
        }

        List<String> names = new ArrayList<>(set);
        Collections.sort(names);
        for (int i = names.size() - 1; i >= 0; i--) {
            System.out.println(names.get(i));
        }
        br.close();
    }
}
