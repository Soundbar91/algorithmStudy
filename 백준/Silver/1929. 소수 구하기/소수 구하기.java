import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] numArr = new int[N + 1];

        for (int i = 2; i <= N; i++){
            numArr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++){
            if (numArr[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= N; j += i){
                numArr[j] = 0;
            }
        }

        for (int i = M; i <= N; i++){
            if (numArr[i] != 0) {
                System.out.println(numArr[i]);
            }
        }

    }
}
