import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            numArr[i] = Math.abs(S - Integer.parseInt(st.nextToken()));
        }

        int result = numArr[0];

        for (int i = 1; i < numArr.length; i++){
            while (numArr[i] != 0){
                int temp = numArr[i];
                numArr[i] = result % numArr[i];
                result = temp;
            }
        }

        System.out.print(result);
    }
}
