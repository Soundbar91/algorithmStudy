import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            System.out.println(N % 9 == 0 || N % 3 == 2 ? "TAK" : "NIE");
        }

        br.close();
    }
}
