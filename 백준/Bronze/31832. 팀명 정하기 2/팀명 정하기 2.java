import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static String[] strings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        strings = new String[N];

        for (int i = 0; i < N; i++) strings[i] = br.readLine();

        for (int i = 0; i < N; i++) {
            if (checkBigSmail(strings[i])) {
                System.out.print(strings[i]);
                System.exit(0);
            }
        }
    }

    public static boolean checkBigSmail(String str) {
        if (str.length() > 10) return false;

        int big = 0;
        int small = 0;
        int hif = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 65 && c <= 90) big++;
            else if (c >= 97 && c <= 122) small++;
            else if (c == 45) hif++;
        }

        if (big + small + hif == 0) return false;
        if (big > small) return false;
        return true;
    }
}
