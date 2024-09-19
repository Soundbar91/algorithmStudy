import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 1)
            System.out.print(1);
        else if (N == 2)
            System.out.print(Math.min(4, ((M + 1) / 2)));
        else if (M < 7)
            System.out.print(Math.min(4, M));
        else
            System.out.print(M - 2);
        
        br.close();
    }
}
