import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static long[] muscle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        muscle = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.print(solve());
    }

    public static long solve() {
        Arrays.sort(muscle);
        long M = muscle.length % 2 != 0 ? muscle[N - 1] : 0;

        if (muscle.length % 2 != 0) {
            for (int i = 0; i < (N / 2) + 1; i++) {
                M = Math.max(M, muscle[i] + muscle[N - i - 2]);
            }
        }
        else {
            for (int i = 0; i < (N / 2) + 1; i++) {

                M = Math.max(M, muscle[i] + muscle[N - i - 1]);
            }
        }
        
        return M;
    }
}
