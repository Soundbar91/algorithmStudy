import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int[] div = {1, 2, 3, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());
            boolean update = false;

            for (int j : div) {
                if (N % j == 0) {
                    long x = N / j;

                    long result = (x + j) * 2;

                    if (result % 3 == 0) {
                        update = true;
                        break;
                    }
                }
            }

            System.out.println(update ? "TAK" : "NIE");
        }

        br.close();
    }
}
