import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int index = -1;
        for (int i = numArr.length - 1; i > 0; i--){
            if (numArr[i] < numArr[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            System.out.print(-1);
            return ;
        }

        int flag = -1;
        for (int i = numArr.length - 1; i > index; i--){
            if (numArr[index] >= numArr[i]) {
                flag = i;
                break;
            }
        }

        int temp = numArr[flag];
        numArr[flag] = numArr[index];
        numArr[index] = temp;

        int cnt = numArr.length - 1;
        index++;

        while(index < cnt) {
            temp = numArr[index];
            numArr[index] = numArr[cnt];
            numArr[cnt] = temp;
            index += 1;
            cnt -= 1;
        }

        for (int i : numArr) {
            System.out.print(i + " ");
        }

    }
}
