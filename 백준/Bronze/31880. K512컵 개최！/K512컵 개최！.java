import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long result = 0;

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) result += Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            long l = Long.parseLong(st.nextToken());
            if (l == 0) continue;
            result *= l;
        }

        System.out.print(result);
    }
}
