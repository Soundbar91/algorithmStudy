import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] numArr = new int[N + 1][M + 1];

        int max = 0;
        int min = 256;

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++){
                numArr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, numArr[i][j]);
                min = Math.min(min, numArr[i][j]);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHigh = 0;

        for (int i = min; i <= max; i++){
            int time = 0;
            int block = B;

            for (int j = 1; j <= N; j++){
                for (int k = 1; k <= M; k++){
                    if (numArr[j][k] > i){
                        block += (numArr[j][k] - i);
                        time += ((numArr[j][k] - i) * 2);
                    }
                    else if (numArr[j][k] < i){
                        block -= (i - numArr[j][k]);
                        time += (i - numArr[j][k]);
                    }
                }
            }

            if (block < 0) continue;
            if (resultTime >= time){
                resultTime = time;
                resultHigh = i;
            }
        }
        System.out.print(resultTime + " ");
        System.out.print(resultHigh);
    }
}
