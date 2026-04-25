import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K == 0 || N == K) {
            System.out.println(1);
            return ;
        }

        int n1 = 1;
        int n2 = 1;
        int n3 = 1;

        for (int i = N; i > 0; i--){
            n1 *= i;
        }
        for (int i = K; i > 0; i--){
            n2 *= i;
        }
        for (int i = N - K; i > 0; i--){
            n3 *= i;
        }

        System.out.println((int)(n1 / (n2 * n3)));
    }
}
