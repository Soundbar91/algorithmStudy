import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();
        long result = 0;
        long pow = 1;
        int M = 1234567891;

        for (int i = 0; i < n; i++){
            result += (ch[i] - 'a' + 1) * (pow);
            pow = (pow * 31) % M;
        }
        System.out.println(result % M);
    }
}
