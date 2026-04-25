import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder A = new StringBuilder();
    static StringBuilder B = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A.append(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) B.append(st.nextToken());

        System.out.print(Math.min(Long.parseLong(String.valueOf(A)), Long.parseLong(String.valueOf(B))));
    }
}
