import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;
    static String pattern;
    static String[] patterns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pattern = br.readLine();
        patterns = pattern.split("\\*");

        while (N-- > 0) {
            String str = br.readLine();

            System.out.println(solve(str) ? "DA" : "NE");
        }

        br.close();
    }

    public static boolean solve(String str) {
        if (patterns[0].length() + patterns[1].length() > str.length())
            return false;

        String left = str.substring(0, patterns[0].length());
        String right = str.substring(str.length() - patterns[1].length());

        return left.equals(patterns[0]) && right.equals(patterns[1]);
    }
}
