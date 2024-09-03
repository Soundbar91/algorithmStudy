import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Main {
    static int N, result;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.equals("ENTER")) {
                result += set.size();
                set.clear();
            }
            else set.add(str);
        }

        if (!set.isEmpty()) result += set.size();
        System.out.print(result);
        br.close();
    }
}
