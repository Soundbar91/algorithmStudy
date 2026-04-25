import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] numArr = new int[1000001];

        for (int i = 2; i <= 1000000; i++){
            numArr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(1000000); i++){
            if (numArr[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= 1000000; j += i){
                numArr[j] = 0;
            }
        }

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0){
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 2; i <= num / 2; i++){
                if (numArr[i] != 0 && numArr[num - i] != 0) cnt += 1;
            }

            sb.append(String.valueOf(cnt)).append('\n');
        }

        System.out.println(sb);
    }
}
