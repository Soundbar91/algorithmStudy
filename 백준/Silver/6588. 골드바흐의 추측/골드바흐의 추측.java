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

        while(true){
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            boolean bool = false;

            for (int i = 3; i <= n / 2 + 1; i += 2){
                if (numArr[i] == 0) continue;
                if (numArr[n - i] != 0) {
                    sb.append(n).append(" = ").append(String.valueOf(i)).append(" + ").append(String.valueOf(n - i)).append('\n');
                    bool = true;
                    break;
                }
            }
            if (!bool) sb.append("Goldbach's conjecture is wrong.").append('\n');
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}

