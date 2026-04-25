import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];

        for (int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++){
            int cnt = 1;

            for (int j = 1; j <= n; j++){
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) cnt++;
            }
            System.out.print(cnt + " ");
        }
    }
}
