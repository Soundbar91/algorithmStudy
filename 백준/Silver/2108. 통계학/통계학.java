import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(br.readLine());
            sum += numArr[i];
        }
        Arrays.sort(numArr);

        boolean bool = false;
        int modeMax = 0;
        int mode = 0;

        for(int i = 0; i < n; i++){
            int jump = 0;
            int count = 1;
            int value = numArr[i];

            for (int j = i + 1; j < n; j++){
                if(value != numArr[j]){
                    break;
                }
                jump++;
                count++;
            }

            if (count > modeMax){
                modeMax = count;
                mode = value;
                bool = true;
            }
            else if (count == modeMax && bool){
                mode = value;
                bool = false;
            }

            i += jump;
        }

        System.out.println((int)Math.round((double) sum / n));
        System.out.println(numArr[n / 2]);
        System.out.println(mode);
        System.out.print(numArr[n - 1] - numArr[0]);
    }
}
