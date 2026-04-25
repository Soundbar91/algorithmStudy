import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int Q;
    static String wow = "WOW";
    static List<String> wows = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Q = Integer.parseInt(br.readLine());

        for (int i = 0; i < Q; i++) {
            wows.add(br.readLine());
        }

        for (int i = 0; i < Q; i++) {
            System.out.println(solve(i));
        }
    }

    public static int solve(int index) {
        String string = wows.get(index);

        if (string.length() <= 2) return 0;
        int count = 0;

        for (int i = 0; i < string.length() - 2; i++) {
            String substring = string.substring(i, i + 3);
            if (substring.equals(wow)) count++;
        }

        return count;
    }
}
