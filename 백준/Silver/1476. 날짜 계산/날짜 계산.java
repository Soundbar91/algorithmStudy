import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int cntE = 1;
        int cntS = 1;
        int cntM = 1;

        while (!(cntE == E && cntM == M && cntS == S)){
            cntE = (cntE % 15) + 1;
            cntS = (cntS % 28) + 1;
            cntM = (cntM % 19) + 1;

            cnt++;
        }

        System.out.print(cnt);
    }
}
