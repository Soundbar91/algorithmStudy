import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] numArr = new int[9];

        for (int i = 0; i < 9; i++){
            numArr[i] = Integer.parseInt(br.readLine());
        }

        int n1 = 0, n2 = 0;
        boolean bool = false;
        Arrays.sort(numArr);

        for (int i = 0; i < 9; i++){
            for (int j = i + 1; j < 9; j++){
                int result = 100;
                for (int k = 0; k < 9; k++){
                    if (k == i || k == j) continue;
                    result -= numArr[k];
                }

                if (result == 0){
                    n1 = i;
                    n2 = j;
                    bool = true;
                    break;
                }
            }
            if (bool) break;
        }

        for (int i = 0; i < 9; i++){
            if (i == n1 || i == n2) continue;
            else System.out.println(numArr[i]);
        }

    }
}
