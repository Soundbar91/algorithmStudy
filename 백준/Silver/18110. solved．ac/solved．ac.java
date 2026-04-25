import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int avgN = (int) Math.round(n * 0.15);
        int[] numArr = new int[n];

        for (int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(numArr);

        int sum = 0;
        for (int i = avgN; i < n - avgN; i++){
            sum += numArr[i];
        }

        System.out.println(Math.round((float) sum / (n - (avgN * 2))));
    }
}
