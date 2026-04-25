import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int index = -1;
        for (int i = n - 1; i > 0; i--) {
            if (numArr[i] > numArr[i - 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.print(-1);
            return;
        }

        int flag = -1;
        for (int i = n - 1; i >= index; i--) {
            if (numArr[index - 1] < numArr[i]) {
                flag = i;
                break;
            }
        }

        int temp = numArr[flag];
        numArr[flag] = numArr[index - 1];
        numArr[index - 1] = temp;

        int cnt = n - 1;

        while (index < cnt) {
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
