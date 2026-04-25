import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[][] numArr = new int[15][15];
        for (int i = 1; i <= 14; i++){
            numArr[0][i] = i;
        }

        for (int i = 1; i <= 14; i++){
            for (int j = 1; j <= 14; j++){
                for (int k = 1; k <= j; k++){
                    numArr[i][j] += numArr[i - 1][k];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(numArr[k][n]).append('\n');
        }
        System.out.print(sb);
    }
}
