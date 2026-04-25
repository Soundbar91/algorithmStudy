import java.io.*;

public class Main {
    static int N;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        System.out.print(solve());
    }

    public static int solve() {
        int blue = 0, red = 0;
        char prev = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != prev) {
                if (c == 'B') blue++;
                else red++;
            }
            prev = c;
        }

        return Math.min(blue, red) + 1;
    }
}
