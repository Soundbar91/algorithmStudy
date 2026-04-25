import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int cnt = 10;
        int weight = 1;

        for(int i = 1; i <= n; i++){
            if (i % cnt == 0){
                weight += 1;
                cnt *= 10;
            }
            result += weight;
        }

        System.out.print(result);
    }
}
