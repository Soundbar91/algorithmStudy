import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long L = N - M;

        long two = calcTwo(N) - (calcTwo(M) + calcTwo(L));
        long five = calcFive(N) - (calcFive(M) + calcFive(L));

        System.out.print(Math.min(two, five));
    }

    public static long calcTwo(long n){
        int cnt = 0;

        while (n >= 2) {
            cnt += n / 2;
            n /= 2;
        }

        return cnt;
    }

    public static long calcFive(long n){
        int cnt = 0;

        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }

        return cnt;
    }
}
